package com.logistics.UsersAndAuth;

import com.logistics.Package.EPackageStatus;
import com.logistics.Package.Package;
import com.logistics.Package.PackageRepository;
import com.logistics.Util.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/authenticate")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PackageRepository packageRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public static AboutCompany  aboutCompany = new AboutCompany("Needy Logistics",
            "Приложението Логистична Компания е задание към курс CSCB025 Практика по програмиране и по реализация на бази данни към Нов Български Университет. \n  Проектът е базиран на Java Spring boot, като се използват: \n Spring Security, Java mail Sender, Jpa, Spring Web и др. \n За База Данни използваме Postgre SQL, а за FrontEnd - Node Js с React и Sap ui5 web компоненти.",
            "Мартин Георгиев",
            "Екатерина Герасимова",
            "Марта Гюрова",
            "Христина Николова",
            "Преслава Петкова",
            "Архитект на приложението | Backend",
            "UX дизайнер на приложението | FrontEnd ",
            "DB Management | Backend",
            "DB Management | Backend",
            "Login/Register | FrontEnd",
            "https://github.com/mrtngv/LC-UI",
            "https://github.com/mrtngv/LCS",
            "a",
            "a",
            "a"
            );

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        String role = "NO_ROLE";
        if(roles.contains(ERoles.ROLE_MODERATOR.toString())){
            role = ERoles.ROLE_MODERATOR.toString();
        }
        else if(roles.contains(ERoles.ROLE_OFFICE_EMPLOYEE.toString())){
            role = ERoles.ROLE_OFFICE_EMPLOYEE.toString();
        }
        else if(roles.contains(ERoles.ROLE_DELIVERY.toString())){
            role = ERoles.ROLE_DELIVERY.toString();
        }
        else if(roles.contains(ERoles.ROLE_CLIENT.toString())){
            role = ERoles.ROLE_CLIENT.toString();
        }
        else {
            role = "NO_ROLE";
        }


        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                userDetails.getEmail(),
                role));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERoles.ROLE_CLIENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        try{
            UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userRepository.findByUsername(userDetails.getUsername()).orElse(user = null);
            if(user!= null) {
                user.setEmail(signUpRequest.getEmail());
                user.setUsername(signUpRequest.getUsername());
                user.setPassword(encoder.encode(signUpRequest.getPassword()));
                userRepository.saveAndFlush(user);
                return ResponseEntity.ok(new MessageResponse("Data modified successfully!"));
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }
        return ResponseEntity.ok(new MessageResponse("There was a problem when modifying your data."));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteUser() {
        try{
            UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userRepository.findByUsername(userDetails.getUsername()).orElse(user = null);
            if(user!= null) {
                user.setEmail(user.getEmail()+"del");
                user.setUsername(user.getUsername()+"del");
                userRepository.saveAndFlush(user);
                return ResponseEntity.ok(new MessageResponse("Your account was deleted successfully."));
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }
        return ResponseEntity.ok(new MessageResponse("There was a problem when deleting your data."));
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        if(allUsers.size()!=0) {
            return ResponseEntity.ok().body(allUsers);
        }
        //This line is impossible ;) M.Georgiev
        return ResponseEntity.ok(new MessageResponse("There are not users at all"));
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping
    public ResponseEntity<?> updateRole(@RequestBody UpdateRoleRequest updateRoleRequest) {

        User user = userRepository.findById(updateRoleRequest.getId()).orElse(user = null);
        if(user == null) {
            return ResponseEntity.ok(new MessageResponse("There is not user with id: " + updateRoleRequest.getId()));
        }

        Role userRole = roleRepository.findByName(updateRoleRequest.getRole()).orElse(userRole=null);
        if(userRole==null) {
            return ResponseEntity.ok(new MessageResponse("Wrong Role send!"));
        }
        if(updateRoleRequest.getAction().equals("addRole")) {
            if(!user.getRoles().contains(userRole)) {
                user.getRoles().add(userRole);
                userRepository.saveAndFlush(user);
                return ResponseEntity.ok(new MessageResponse("Role added successfully !"));
            }
        }else if (updateRoleRequest.getAction().equals("removeRole")){
            if(user.getRoles().contains(userRole)) {
                user.getRoles().remove(userRole);
                userRepository.saveAndFlush(user);
                return ResponseEntity.ok(new MessageResponse("Role removed successfully !"));
            }
        }
        return ResponseEntity.ok(new MessageResponse("There was problem updating the roles of the user!"));
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @DeleteMapping("/{packageID}")
    public ResponseEntity<?> deleteUserPerm(@PathVariable("packageID") Long id) {

        User userToBeDeleted = userRepository.findById(id).orElse(userToBeDeleted=null);
        if(userToBeDeleted == null) {
            return ResponseEntity.ok(new MessageResponse("There is not any user with id: " + id));
        }

        List<Package> packages = packageRepository.findAll();
        for(Package p : packages) {
            if(p.getPackageUsers().contains(userToBeDeleted)) {
                p.getPackageUsers().remove(userToBeDeleted);
                packageRepository.save(p);
            }
        }

        userToBeDeleted.setRoles(new HashSet<>());
        userRepository.saveAndFlush(userToBeDeleted);

        try{
            userRepository.delete(userToBeDeleted);
            return ResponseEntity.ok(new MessageResponse("user with id: " + id+ " has been deleted!"));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/statistics")
    public Statistics getUsersPerRole() {

        Role a = roleRepository.findByName(ERoles.ROLE_OFFICE_EMPLOYEE)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Role b = roleRepository.findByName(ERoles.ROLE_DELIVERY)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Role c = roleRepository.findByName(ERoles.ROLE_CLIENT)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        final Role userRole = roleRepository.findByName(ERoles.ROLE_OFFICE_EMPLOYEE).orElseThrow(() -> new IllegalStateException());
        LocalDate n = LocalDate.now().minusDays(3);

        long one = userRepository.findAll().stream().filter(v -> v.getRoles().contains(a)).count();
        long two = userRepository.findAll().stream().filter(v -> v.getRoles().contains(b)).count();
        long three = userRepository.findAll().stream().filter(v -> v.getRoles().contains(c)).count();
        long four = packageRepository.findAll().stream().filter(p -> p.getPackageUsers().stream().filter(u -> u.getRoles().contains(userRole)).findFirst().isPresent()).count();
        long five = packageRepository.findAll().stream().count() - four;
        long six = packageRepository.findAll().stream().filter(p -> p.getePackageStatus().name().equals(EPackageStatus.REGISTERED.toString()) && p.getDateOfRequest().toLocalDate().isAfter(n)).count();
        long seven = packageRepository.findAll().stream().filter(p -> p.getePackageStatus().name().equals(EPackageStatus.ANNULLED.toString()) && p.getDateOfRequest().toLocalDate().isAfter(n)).count();
        long eight = packageRepository.findAll().stream().filter(p -> p.getePackageStatus().name().equals(EPackageStatus.DELIVERED.toString()) && p.getDateOfRequest().toLocalDate().isAfter(n)).count();
        long nine = packageRepository.findAll().stream().filter(p -> p.getePackageStatus().name().equals(EPackageStatus.IN_PROCESS_OF_DELIVERING.toString()) && p.getDateOfRequest().toLocalDate().isAfter(n)).count();
        long ten = packageRepository.findAll().stream().filter(p -> p.getePackageStatus().name().equals(EPackageStatus.AWAITING_PICK_UP.toString()) && p.getDateOfRequest().toLocalDate().isAfter(n)).count();
        double eleven = 0;
        double twelve = 0;

        List<Package> packages = packageRepository.findAll();
        for(Package as : packages ) {
            if(as.getDateOfRequest().toLocalDate().isAfter(n.minusDays(4))) {
                eleven += as.getPrice();
            }
            twelve+=as.getPrice();
        }

        twelve = twelve - eleven;



        Statistics s = new Statistics();
        s.setStatistic1(one);
        s.setStatistic2(two);
        s.setStatistic3(three);
        s.setStatistic4(four);
        s.setStatistic5(five);
        s.setStatistic6(six);
        s.setStatistic7(seven);
        s.setStatistic8(eight);
        s.setStatistic9(nine);
        s.setStatistic10(ten);
        s.setStatistics17(eleven);
        s.setStatistics18(twelve);

        return s;
    }

    @GetMapping("/aboutCompany")
    public AboutCompany getAboutCompany() {
        return aboutCompany;
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping("/aboutCompany")
    public void editAboutCompany(@RequestBody AboutCompany aboutCompanyRequest) {
       aboutCompany.setName(aboutCompanyRequest.getName());
       aboutCompany.setAbout(aboutCompanyRequest.getAbout());
    }
}
