package org.example;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(double amount, String threadName) {
        System.out.println(threadName + " is trying to withdraw " + amount);

        if (balance >= amount) {
            System.out.println(threadName + " successfully withdrew " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println(threadName + " failed to withdraw. Insufficient funds.");
        }
    }

    public synchronized void deposit(double amount, String threadName) {
        System.out.println(threadName + " is depositing " + amount);
        balance += amount;
        System.out.println(threadName + " successfully deposited " + amount);
        System.out.println("Current balance: " + balance);
    }
}