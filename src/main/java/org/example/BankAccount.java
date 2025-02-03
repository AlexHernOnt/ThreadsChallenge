package org.example;

public class BankAccount {

    private double balance;

    /**
     * Constructor with start balance.
     *
     * @param initialBalance The initial balance of the account.
     */
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Withdraws x amount if sufficient
     *
     * @param amount     The amount to withdraw
     * @param threadName The name of the thread
     * */

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

    /**
     * Deposits x amount into the account
     *
     * @param amount     The amount to deposit
     * @param threadName The name of the thread
     */
    public synchronized void deposit(double amount, String threadName) {
        System.out.println(threadName + " is depositing " + amount);
        balance += amount;
        System.out.println(threadName + " successfully deposited " + amount);
        System.out.println("Current balance: " + balance);
    }
}
