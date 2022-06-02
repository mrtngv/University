package com.example.project_db.application;

import com.example.project_db.program.Program;
import com.example.project_db.student.Student;

import java.io.Serializable;
import java.util.Objects;

public class ApplicationId implements Serializable {
    private Student student;
    private Program program;
    private int year;

    public ApplicationId(Student student, Program program, int year) {
        this.student = student;
        this.program = program;
        this.year = year;
    }

    public ApplicationId(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationId)) return false;
        ApplicationId that = (ApplicationId) o;
        return year == that.year && Objects.equals(student, that.student) && Objects.equals(program, that.program);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, program, year);
    }
}
