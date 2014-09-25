package me.drewhoener.compsci.commented;

import java.util.ArrayList;

public class AnnotatedPrimes {

    static boolean debug = true;

    public static void main(String[] args) {
        AnnotatedPrimes p = new AnnotatedPrimes();

        for (int i : p.getPrimes(50)) {
            System.out.println(i);
        }

    }

    public ArrayList<Integer> getPrimes(int before) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);//because 2 is a weird prime number, get that in there first

        for (int num = 3; num <= before; num++) {

            if (isPrime(num)) {
                list.add(num);
            }

        }

        return list;
    }

    public boolean isPrime(int num) {
        //Works kind of like "Innocent until proven Guilty". We have to assume that It's prime until we know for sure that
        //It has other factors

        for (int i = 2; i < num; i++) {
            //If it divides evenly into something other than itself and one (we've excluded those) then it's not prime.
            //We can say for sure, and return false.
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
