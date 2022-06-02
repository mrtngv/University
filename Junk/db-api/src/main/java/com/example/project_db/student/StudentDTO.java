package com.example.project_db.student;

import com.example.project_db.university.University;

public class StudentDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private University university;

    public StudentDTO(String firstName, String middleName, String lastName, University university) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.university = university;
    }

    public StudentDTO(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
