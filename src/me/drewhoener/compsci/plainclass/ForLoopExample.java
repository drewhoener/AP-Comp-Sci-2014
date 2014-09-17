package me.drewhoener.compsci.plainclass;

public class ForLoopExample {

    static int iterations = 70;
    static String topBottom = "*";
    static String middle = "*";

    public static void main(String[] args) {
        print1();
    }

    public static void print1() {

        iterations -= 2;

        for (int i = 0; i < iterations; i++) {
            topBottom += "*";
        }

        topBottom += "*";

        for (int i = 0; i < iterations; i++) {
            middle += " ";
        }

        middle += "*";

        System.out.println(topBottom);

        for (int i = 0; i < iterations; i++) {
            System.out.println(middle);
        }

        System.out.println(topBottom);
    }
}
