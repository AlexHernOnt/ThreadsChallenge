package org.example;

class BankAccount {
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










class WithdrawalThread extends Thread {
    private BankAccount account;
    private double amount;
    private String threadName;

    public WithdrawalThread(BankAccount account, double amount, String threadName) {
        this.account = account;
        this.amount = amount;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        account.withdraw(amount, threadName);
    }
}

class DepositThread extends Thread {
    private final BankAccount account;
    private final double amount;
    private final String threadName;

    public DepositThread(BankAccount account, double amount, String threadName) {
        this.account = account;
        this.amount = amount;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        account.deposit(amount, threadName);
    }
}












public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new WithdrawalThread(account, 700, "Thread 1 (Withdraw)");
        Thread t2 = new WithdrawalThread(account, 500, "Thread 2 (Withdraw)");
        Thread t3 = new DepositThread(account, 300, "Thread 3 (Deposit)");
        Thread t4 = new DepositThread(account, 800, "Thread 4 (Deposit)");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
