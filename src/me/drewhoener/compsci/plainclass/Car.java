package me.drewhoener.compsci.plainclass;

public class Car {

    public String model;
    public boolean isBroken;
    public double totalDistance;
    public double position;

    public Car() {
        this.model = "";
        this.isBroken = false;
        this.totalDistance = 0;
        this.position = 0;
    }

    public Car(String name, double position) {
        this.model = name;
        this.isBroken = false;
        this.totalDistance = 0;
        this.position = position;
    }

    public Car(String model, boolean isBroken, double totalDistance, double pos) {
        this.model = model;
        this.isBroken = isBroken;
        this.totalDistance = totalDistance;
        this.position = pos;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public String getModel() {
        return model;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getPosition() {
        return position;
    }

    public void setBroken(boolean isBroken) {
        this.isBroken = isBroken;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void drive(double dist) {
        if (!this.isBroken) {
            this.position += dist;
            this.totalDistance += Math.abs(dist);
        } else {
            System.out.println("Cannot drive! Car is broken!");
        }
    }
}
