package me.drewhoener.compsci.plainclass;

public class CarTest {

    public static void main(String[] args) {
        CarTest ct = new CarTest();
    }

    public CarTest() {
        init();
    }

    public void init() {
        Car car1 = new Car("Ford", 0);
        Car car2 = new Car();
        car2.setModel("Honda");

        car1.drive(5);
        car2.drive(-5);

        System.out.println("Car 1 Position: " + car1.getPosition());
        System.out.println("Car 1 Distance: " + car1.getTotalDistance());

        System.out.println("Car 2 Position: " + car2.getPosition());
        System.out.println("Car 2 Distance: " + car2.getTotalDistance());
    }
}
