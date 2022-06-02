package com.example.project_db.program;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProgramRequest {

    @NotBlank
    @Size(min = 2,max = 50)
    private String name;

    @NotBlank
    private Integer capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
