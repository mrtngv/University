package com.example.project_db.student;

import com.example.project_db.university.University;
import com.example.project_db.university.UniversityRepository;
import com.example.project_db.university.UniversityRequest;
import com.example.project_db.university.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;
    private final UniversityRepository universityRepository;

    @Autowired
    public StudentController(StudentService studentService, UniversityRepository universityRepository) {
        this.studentService = studentService;
        this.universityRepository = universityRepository;
    }

    @GetMapping
    public List<University> getStudents() {
        return universityRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity<Object> insertStudent(@RequestBody StudentRequest studentRequest) throws Exception {
        return studentService.insertStudent(studentRequest);
    }
}
