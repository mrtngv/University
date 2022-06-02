package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ide {
    private String name;
    private List<Project> projects;

    public Ide(String name) {
        this.name = name;
        this.projects = new ArrayList<Project>();
    }

    public void addProject(Project project) {
        if (!projects.contains(project)) {
            this.projects.add(project);
        }
    }

    // Task 1
    public void renameProject(Project project, String newName) throws NotInProjectsListException{
        if(projects.contains(project))
            project.setName(newName);
        else
            throw new NotInProjectsListException(project + " IS NOT in the list of projects");
    }

    // Task 2
    public void saveProjectsInFile(String filename) {
        try(FileWriter f = new FileWriter(filename,false);){
            for(int cnt=0;cnt<projects.size();cnt++) {
                f.append(projects.get(cnt).getName());
                f.append("&");
            }
        }catch (IOException ioexception){
            System.out.println(ioexception);
        }
    }

    // Task 3
    public void serializeProject(Project project, String filename) {
        try(FileOutputStream f = new FileOutputStream(filename); ObjectOutputStream o = new ObjectOutputStream(f);){
            o.writeObject(project);
        }catch (IOException excepiton){
            System.err.println(excepiton);
        }
    }

    // Task 3
    public Project deserializeProject(String filename) {
        try(FileInputStream f = new FileInputStream(filename);ObjectInputStream o = new ObjectInputStream(f);){
            Project p = (Project)o.readObject();
            return p;
        }catch (ClassNotFoundException c){
            System.err.println(c);
        }catch (IOException e){
            System.err.println(e);
        }
        return null;
    }

    // Task 4
    public boolean readProjectName(Project project, String targetString) {
        int l = 0,cnt = 0;
        while(l != -1){
            l = project.getName().indexOf(targetString,l);
            if(l != -1){
                cnt ++;
                l = l + targetString.length();
            }
        }
        if(cnt>1)
            return true;
        return false;
    }

    // Task 5
    public void runProjects(Project project) {
        new ProjectThread(project);
    }

    @Override
    public String toString() {
        return "Ide{" +
                "name='" + name + '\'' +
                '}';
    }
}

class ProjectThread implements Runnable{
    Project p;
    Thread t;

    ProjectThread(Project project){
        p = project;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        p.runProject();
    }
}