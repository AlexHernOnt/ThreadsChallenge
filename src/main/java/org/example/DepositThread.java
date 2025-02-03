package org.example;

public class DepositThread extends Thread {
    private final BankAccount account;
    private final double amount;
    private final String threadName;
    private int waitTime;

    public DepositThread(BankAccount account, int waitTime, double amount, String threadName) {
        this.account = account;
        this.amount = amount;
        this.waitTime = waitTime;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        boolean exit = false;

        System.out.println(threadName + " began to run!");
        while (!exit) {
            try {
                Thread.sleep(waitTime * 1000);
                account.deposit(amount, threadName);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
