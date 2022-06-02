package com.example.project_db.program;
import com.example.project_db.university.University;
import com.example.project_db.university.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/program")
public class ProgramController {
    public static int year = 1999;
    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    public List<Program> getPrograms() {
        return programService.getPrograms();
    }

    @PostMapping
    public void addProgram(@RequestBody ProgramRequest programRequest) {
        programService.addProgram(programRequest);
    }

    @GetMapping("year")
    public int getYear() {
        return year;
    }

    @GetMapping("/next")
    public int nextYear() {
        return ++year;
    }




}
