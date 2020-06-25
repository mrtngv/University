package com.company;

import java.io.Serializable;

public class Project implements Serializable {
    private String name;
    private ProjectType projectType;
    private int numberOfFiles;

    public Project(String name, ProjectType projectType, int numberOfFiles) {
        this.name = name;
        this.projectType = projectType;
        this.numberOfFiles = numberOfFiles;
    }

    public void runProject() {
        System.out.println("Running " + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", projectType=" + projectType +
                ", numberOfFiles=" + numberOfFiles +
                '}';
    }
}