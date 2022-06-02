package com.example.project_db.configuration;


import com.example.project_db.program.Program;
import com.example.project_db.program.ProgramRepository;
import com.example.project_db.student.Student;
import com.example.project_db.student.StudentRepository;
import com.example.project_db.university.University;
import com.example.project_db.university.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ProjectConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UniversityRepository universityRepository,
                                        StudentRepository studentRepository,
                                        ProgramRepository programRepository) {
        return args -> {
            University university1 = new University("NBU", "Sofia", "Bulgaria");
            University university2 = new University("Sofia University", "Sofia", "Bulgaria");
            University university3 = new University("Технически Университет", "Sofia", "Bulgaria");
            universityRepository.saveAll(Arrays.asList(university1,university2,university3));

            Student student1 = new Student("Martin","Petrov", "Georgiev",university1);
            Student student2 = new Student("Aleksander","Nikolov", "Hristov",university1);
            Student student3 = new Student("Svetoslav","Petrov", "Vinev",university2);
            Student student4 = new Student("Trifon","Pavlov", "Trachev",university3);
            studentRepository.saveAll(Arrays.asList(student1,student2,student3,student4));

            Program program1 = new Program("Развитие на Европейските Студенти", 100);
            Program program2 = new Program("Култура и Изкуство", 50);
            programRepository.saveAll(Arrays.asList(program1,program2));

        };
    }
}