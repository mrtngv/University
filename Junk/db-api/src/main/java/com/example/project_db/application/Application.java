package com.example.project_db.application;


import com.example.project_db.application.Application;
import com.example.project_db.program.Program;
import com.example.project_db.program.ProgramController;
import com.example.project_db.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@IdClass(ApplicationId.class)
@Table(
        name= "application"
)
public class Application {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "program_id")
    Program program;

    @Id
    @NotNull
    @Min(1)
    @Column(name = "year")
    private Integer year;

    public Application() {
        year = ProgramController.year;
    }

    public Application(Student student, Program program) {
        this.student = student;
        this.program = program;
        year = ProgramController.year;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
