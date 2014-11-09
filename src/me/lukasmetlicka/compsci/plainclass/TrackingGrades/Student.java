package me.lukasmetlicka.compsci.plainclass.TrackingGrades;

// ****************************************************************
//   Student.java
//
//   Define a student class that stores name, score on test 1, and
//   score on test 2.  Methods prompt for and read in grades,
//   compute the average, and return a string containing student’s info.
// ****************************************************************
import java.util.Scanner;

public class Student
{
    private String name;
    private double Test1;
    private double Test2;

    public Student(String studentName)
    {
       name = studentName;
        Test1 = 0;
        Test2 = 0;
    }

    public void inputGrades()
    {
        Scanner s =  new Scanner(System.in);
        System.out.println("Enter "+name+"'s score on test #1:");
        Test1 = s.nextDouble();
        System.out.println("Enter "+name+"'s score on test #2:");
        Test2 = s.nextDouble();
    }

    public double getAverage(){
        return (Test1 + Test2)/2;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return "Name: "+name+"\tTest 1: "+Test1+"\tTest 2: "+Test2;
    }

}

