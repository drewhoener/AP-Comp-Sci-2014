package me.drewhoener.compsci.plainclass;

public class Employee {

    private String employeeName;
    private int age;
    private String job;

    public Employee() {
        this.employeeName = "John Doe";
        this.age = 0;
        this.job = "";
    }

    public Employee(String name) {
        this.employeeName = name;
        this.age = 0;
        this.job = "";
    }

    public Employee(String name, int age, String job) {
        this.employeeName = name;
        this.age = age;
        this.job = job;
    }

    public void printData() {
        System.out.println();
        System.out.println("Name: " + this.employeeName);
        System.out.println("Age: " + this.age);
        System.out.println("Job: " + this.job);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String geEmployeetName() {
        return this.employeeName;
    }
}
