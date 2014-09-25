package me.drewhoener.compsci.plainclass;

public class Primes {

    static boolean debug = false;

    public static void main(String[] args) {
        Primes p = new Primes();

        System.out.println(p.factorial(5));

        if (debug) p.getPrimes(10000);


    }

    public void getPrimes(int before) {
        //because 2 is a weird prime number, get that in there first
        System.out.print("2");

        for (int num = 3; num <= before; num++) {


            if (isPrime(num)) {
                System.out.print(", " + num);
            }

        }


    }

    public boolean isPrime(int num) {

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int factorial(int num) {
        int factorial = 1;

        for (int i = num; i > 1; i--) {
            factorial *= i;
        }

        return factorial;
    }

}
