package me.lukasmetlicka.compsci.plainclass;

/**
 * Created by LukasMetlicka on 10/31/14.
 */
public class EnoughTimeForLunch {
    public int largest(int a, int b){

        if ( a > b ){

            return a;

        } else {

            return b;

        }

    }

    public static boolean enoughTimeForLunch(int hour1, int minute1, int hour2, int minute2){

        if ( hour2 - hour1 >= 1 ){

            return true;

        }
        else if ( minute2 - minute1 >= 45 ){

            return true;

        } else {

            return false;

        }

        }

    }
