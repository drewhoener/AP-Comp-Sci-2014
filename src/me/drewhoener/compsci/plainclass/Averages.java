package me.drewhoener.compsci.plainclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Averages {

    Scanner scan;
    List<Double> list = new ArrayList<Double>();

    public static void main(String[] args) {
        Averages avg = new Averages();
        avg.compute();
    }

    public Averages() {
        scan = new Scanner(System.in);

    }


    public void compute() {


        newPrint("Input a list of numbers: ");

        /*
        * Works with least errors, but still relies on hard-coding the number of numbers to scan for
        * */

        /*
        list.add(scan.nextDouble());
        list.add(scan.nextDouble());
        list.add(scan.nextDouble());
        */

        /*
        * Less stable, but easier to use any amount of numbers desired.
        * */

        String[] list1 = scan.nextLine().trim().split(" ");

        for (String s : list1) {
            try {
                list.add(Double.parseDouble(s));
            } catch (Exception e) {    //Just catch any fatal errors...
                newPrintReturn("Couldn't get the doubles from the input string! Be sure you're inputting valid numbers!");
            }
        }


        double avg = 0;

        for (double d : list) {
            avg += d;
        }

        newPrintReturn("Your average is: " + avg / 3);

    }

    public void newPrint(String s) {
        System.out.print(s);
    }

    public void newPrintReturn(String s) {
        System.out.println(s);
    }
}
