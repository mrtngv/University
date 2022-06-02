package com.example.project_db.student;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentRequest {
    @NotBlank
    @Size(min = 2,max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2,max = 50)
    private String middleName;

    @NotBlank
    @Size(min = 2,max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 2,max = 50)
    private String university;

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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
