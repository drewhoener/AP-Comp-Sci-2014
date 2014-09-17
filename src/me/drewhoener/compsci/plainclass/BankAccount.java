package me.drewhoener.compsci.plainclass;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(double bal) {
        this.balance = bal;
    }

    public void withdraw(double withdraw) {
        this.balance -= withdraw;
    }

    public void deposit(double deposit) {
        this.balance += deposit;
    }

    public double getBalance() {
        return balance;
    }
}
