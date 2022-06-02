package com.example.project_db.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;


    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    public ResponseEntity<Object> insertUniversity(UniversityRequest universityRequest) {
        University university = new University(universityRequest.getName(), universityRequest.getCity(), universityRequest.getCountry());
        if(universityRequest.getName().length()>2 && universityRequest.getCity().length()>2 && universityRequest.getCountry().length()>2) {
            universityRepository.save(university);
        }
        return ResponseEntity.ok().body(universityRequest);
    }

    public List<String> getNames() {
        return universityRepository.findAll().stream().map(m -> m.getName()).collect(Collectors.toList());
    }
}
