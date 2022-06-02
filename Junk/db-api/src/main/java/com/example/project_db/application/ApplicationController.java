package com.example.project_db.application;

import com.example.project_db.program.Program;
import com.example.project_db.program.ProgramService;
import com.example.project_db.university.University;
import com.example.project_db.university.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/application")
public class ApplicationController {
    public static int year = 1999;
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getApplications() {
        return applicationService.getApplications();
    }

}
