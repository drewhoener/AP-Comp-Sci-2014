package me.drewhoener.compsci.plainclass;

import java.util.Scanner;

/*
* @author Drew Hoener
* */
public class BMI {

    /*
    BMI = (weight/height^2) * 703
     */

    //less than
    double underWeight = 18.5;
    double normalWeight = 24.9;
    double overWeight = 29.9;
    double obese = 30.0;

    Scanner scanner;

    public static void main(String[] args) {
        BMI bmi = new BMI();
    }

    public BMI() {
        scanner = new Scanner(System.in);
        init();
    }

    public void init() {
        double h1;
        double h2;
        double w1;
        double w2;

        System.out.println("Enter Information for Person 1");
        System.out.print("Height (In Inches): ");
        h1 = scanner.nextDouble();

        System.out.println();

        System.out.print("Weight (In Pounds): ");
        w1 = scanner.nextDouble();

        System.out.println();
        System.out.println();

        System.out.println("Enter Information for Person 2");

        System.out.print("Height (In Inches): ");
        h2 = scanner.nextDouble();

        System.out.println();

        System.out.print("Weight (In Pounds): ");
        w2 = scanner.nextDouble();

        System.out.println();
        System.out.println();

        System.out.println("BMI for person 1: " + this.calcBMI(h1, w1));
        System.out.println();
        System.out.println("Weight Category: " + this.weightClass(this.calcBMI(h1, w1)));

        System.out.println();
        System.out.println();

        System.out.println("BMI for person 2: " + +this.calcBMI(h2, w2));
        System.out.println();
        System.out.println("Weight Category: " + this.weightClass(this.calcBMI(h2, w2)));

        System.out.println();
        System.out.println();

        System.out.println("Difference of both BMIs: " + (this.calcBMI(h1, w1) - this.calcBMI(h2, w2)));
    }

    public double calcBMI(double height, double weight) {
        return (weight / (height * height)) * 703;
    }

    public String weightClass(double bmi) {
        if (bmi < this.underWeight) {
            return "Underweight";
        } else if (bmi > this.underWeight && bmi < this.normalWeight) {
            return "Normal Weight";
        } else if (bmi > this.normalWeight && bmi < this.overWeight) {
            return "Overweight";
        } else {
            return "Obese";
        }


    }

}
