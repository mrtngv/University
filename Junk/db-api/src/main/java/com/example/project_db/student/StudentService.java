package com.example.project_db.student;

import com.example.project_db.university.University;
import com.example.project_db.university.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;


    @Autowired
    public StudentService (StudentRepository studentRepository, UniversityRepository universityRepository) {
        this.studentRepository = studentRepository;
        this.universityRepository = universityRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<Object> insertStudent(StudentRequest studentRequest) throws Exception {
        University u = universityRepository.findAll().stream().filter(a -> a.getName()
                .equals(studentRequest.getUniversity())).findFirst().orElseThrow(() -> new Exception("Not found"));
        Student student = new Student(studentRequest.getFirstName(),studentRequest.getMiddleName(),studentRequest.getLastName(), u);
        if(studentRequest.getLastName().length()>2 &&
        studentRequest.getFirstName().length()>2 &&
        studentRequest.getMiddleName().length()>2 &&
        studentRequest.getUniversity().length()>2) {
            studentRepository.save(student);
            return ResponseEntity.ok().body(studentRequest);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    public List<StudentDTO> getAllStudentDTO() {
        return studentRepository.findAll().stream().map(StudentService::buildStudentDTO).collect(Collectors.toList());
    }

    private static StudentDTO buildStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setMiddleName(student.getMiddleName());
        studentDTO.setLastName(student.getFamilyName());
        studentDTO.setUniversity(student.getUniversity());
        return studentDTO;
    }
}