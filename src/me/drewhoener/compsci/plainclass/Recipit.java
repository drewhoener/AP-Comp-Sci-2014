package me.drewhoener.compsci.plainclass;

public class Recipit {

    static int subTotal = 30 + 40 + 20;
    static double tax = subTotal * .08;
    static double tip = subTotal * .15;

    public static void main(String[] args) {
        System.out.print("Subtotal: ");
        System.out.println(subTotal);
        System.out.println("Tax is: " + tax);
        System.out.println("Tip : " + tip);

        /*
        * Debug
        * */
        System.out.println(subTotal);
        System.out.println(tax);
        System.out.println(tip);

        /*
        * Total value
        * */
        System.out.println("Total is : " + (subTotal + tax + tip));


    }
}
