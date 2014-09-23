package me.drewhoener.compsci.plainclass;

public class NestedFor {

    public static void main(String[] args) {
        NestedFor nf = new NestedFor();
    }

    public NestedFor() {
        init();
    }

    public void init() {
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5; j++) {


                if ((j == (-1 * i + 6))) {
                    System.out.print(i);

                } else {
                    System.out.print(".");
                }


                //Print dots equal to however many
                //then print the number
                //then print remaining dots
            }


            System.out.println();
        }
    }

}
