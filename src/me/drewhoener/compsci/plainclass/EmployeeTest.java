package me.drewhoener.compsci.plainclass;

public class EmployeeTest {

    public static void main(String[] args) {
        EmployeeTest et = new EmployeeTest();
    }

    public EmployeeTest() {
        init();
    }

    public void init() {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Jacob Michaels", 20, "Janitor");
        Employee e3 = new Employee("Joseph");

        e1.printData();
        e2.printData();
        e3.printData();

        e1.setEmployeeName("Henry Soohoo");

        e1.printData();
        e2.printData();
        e3.printData();
    }

}
