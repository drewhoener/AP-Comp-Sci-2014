package me.lukasmetlicka.compsci.plainclass.TrackingGrades;

public class Grades
{
    public static void main(String[] args)
    {
        Student student1 = new Student("Mary");
        Student student2 = new Student("Mike");

        student1.inputGrades();
        System.out.println("Mary: "+student1.getAverage());

        student2.inputGrades();
        System.out.println("Mike: "+student2.getAverage());

    }
}

