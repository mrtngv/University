package com.company;

public class Main {

    public static void main(String[] args) {

        Ide myIde = new Ide("MYIDE P300");

        Project p1 = new Project("Minecraft",ProjectType.GUI,1532);
        Project p2 = new Project("Counter-Strike",ProjectType.GUI,10000);
        Project p3 = new Project("Kontrolno 2 po java, variant 4",ProjectType.CONSOLE,5);
        Project p4 = new Project("Subway Surfers",ProjectType.GUI,5327);

        myIde.addProject(p1);
        myIde.addProject(p2);
        myIde.addProject(p4);

        // ----------------- Problem 1
        try {
            myIde.renameProject(p1, "Ultra Minecraft" + p1.getName());
        }catch (NotInProjectsListException e){
            System.err.println(e);
        }
        try {
            myIde.renameProject(p3, "This will not pass");
        }catch (NotInProjectsListException e){
            System.err.println(e);
        }

        System.out.println(p1);
        System.out.println(p3);
        System.out.println();

        //------------------End of Problem 1

        //----------------- Problem 2
        myIde.saveProjectsInFile("projectsNow"); // try with resources
        // ---------------- End of Problem 2

        // ---------------- Problem 3
        //------------------ A
        myIde.serializeProject(p1,"m_proj.ser");
        // ----------------- B
        Project buffP1 = myIde.deserializeProject("m_proj.ser");
        //-------------------
        System.out.println("Deserializaciq ===> " + buffP1);
        System.out.println();

        //-----------------End of Proble 3

        //---------------- Problem 4

        System.out.println("P1 More than once ===> " + myIde.readProjectName(p1,"craft"));
        System.out.println("P4 More than once ===> " + myIde.readProjectName(p4,"Sub"));
        System.out.println();

        //---------------- END of Problem 4

        //----------------Problem 5
        myIde.runProjects(p1);
        myIde.runProjects(p2);
        myIde.runProjects(p4);
        //------------------End of Proble 5

    }
}
