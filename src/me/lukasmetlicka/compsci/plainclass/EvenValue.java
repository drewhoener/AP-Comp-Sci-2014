package me.lukasmetlicka.compsci.plainclass;

/**
 * Created by LukasMetlicka on 10/24/14.
 */
public class EvenValue {

    public static int NumOfEvenDigits(int number){

        int numOfEvens = 0;
        boolean shouldRepeat = true;
        while (shouldRepeat){

            if ( (number % 10) % 2 == 0 ){

                numOfEvens++;

            }
            number /= 10;
            if ( number == 0 ) {
                shouldRepeat = false;
            }

        }
        return numOfEvens;
    }

    public static void main(String[] ags){

        System.out.println(NumOfEvenDigits(345678));

    }

}
