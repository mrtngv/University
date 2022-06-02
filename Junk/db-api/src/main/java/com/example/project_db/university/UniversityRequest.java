package com.example.project_db.university;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UniversityRequest {

    @NotBlank
    @Size(min = 2,max = 50)
    private String name;

    @NotBlank
    @Size(min = 2,max = 50)
    private String city;

    @NotBlank
    @Size(min = 2,max = 50)
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
