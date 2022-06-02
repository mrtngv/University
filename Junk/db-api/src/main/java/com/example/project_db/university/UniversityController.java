package com.example.project_db.university;
import com.example.project_db.program.Program;
import com.example.project_db.program.ProgramController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/university")
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getUniversities() {
        return universityService.getUniversities();
    }

    @GetMapping("/test")
    public int getYear() {
        return ProgramController.year;
    }

    @PostMapping()
    public ResponseEntity<Object> insertUniversity(@RequestBody UniversityRequest universityRequest) {
        return universityService.insertUniversity(universityRequest);
    }

    @GetMapping("/names")
    public List<String> getNames() {
        return universityService.getNames();
    }
}
