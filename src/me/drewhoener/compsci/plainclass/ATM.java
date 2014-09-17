package me.drewhoener.compsci.plainclass;

import java.util.Scanner;

public class ATM {

    private BankAccount ba1;
    private Scanner scan;
    private boolean running = true;

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.init();
    }


    public void init() {
        ba1 = new BankAccount();
        scan = new Scanner(System.in);

        while (running) {
            System.out.print("Command: ");
            String[] strings = scan.nextLine().trim().split(" ");
            if (strings.length > 2 || strings.length <= 0) {
                System.out.println("Incorrect Arguments!");
            } else {
                if (strings.length == 1) {
                    if (strings[0].toLowerCase().contains("bal")) {
                        System.out.println("Your Balance is: $" + ba1.getBalance());
                    } else if (strings[0].toLowerCase().contains("stop")) {
                        running = false;
                    }
                } else {
                    if (strings.length == 2) {
                        if (strings[0].toLowerCase().contains("deposit")) {
                            try {
                                double deposit = Double.parseDouble(strings[1]);
                                ba1.deposit(deposit);
                                System.out.println("Added $" + deposit + " to your account");
                                System.out.println("Your balance is now: $" + ba1.getBalance());
                            } catch (Exception e) {
                                System.out.println("Couldn't get the amount to deposit from the String!");
                            }
                        } else if (strings[0].toLowerCase().contains("withdraw")) {
                            try {
                                double withdraw = Double.parseDouble(strings[1]);
                                ba1.withdraw(withdraw);
                                System.out.println("Withdrew $" + withdraw + " from your account");
                                System.out.println("Your balance is now: $" + ba1.getBalance());
                            } catch (Exception e) {
                                System.out.println("Couldn't get the amount to deposit from the String!");
                            }
                        }
                    }
                }
            }
        }

        System.out.println();
        System.out.println("Stopping....");
        System.out.println();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Program lacks patience...");
        }
        scan.close();


    }

    private Scanner getScan() {
        return this.scan;
    }


}
