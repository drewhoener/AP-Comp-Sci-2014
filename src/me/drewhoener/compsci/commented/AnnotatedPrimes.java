package me.drewhoener.compsci.commented;

import java.util.ArrayList;

public class AnnotatedPrimes {

    public static void main(String[] args) {
        AnnotatedPrimes p = new AnnotatedPrimes();

        for (int i : p.getPrimes(50)) {
            System.out.println(i);
        }

    }

    public ArrayList<Integer> getPrimes(int before) {
        boolean prime = false;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);//because 2 is a weird prime number, get that in there first

        for (int num = 3; num <= before; num++) {

            if (getFactors(num).size() > 2) {
                list.add(num);
            }

        }

        return list;
    }

    public ArrayList<Integer> getFactors(int num) {
        boolean prime = true;
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);

        if (num != 1) list.add(num);

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                prime = false;
            }
        }

        if (prime) {
            list.add(num);
        }


        return list;
    }

}
