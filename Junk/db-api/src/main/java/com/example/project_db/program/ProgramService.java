package com.example.project_db.program;

import com.example.project_db.university.University;
import com.example.project_db.university.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;


    @Autowired
    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> getPrograms() {
        return programRepository.findAll();
    }

    public void addProgram(ProgramRequest programRequest) {
        Program program = new Program(programRequest.getName(),programRequest.getCapacity());
        if(programRequest.getName().length()>2 && programRequest.getCapacity()>0){
            programRepository.save(program);
        }
    }
}
