package org.example;

public class WithdrawalThread extends Thread {
    private final BankAccount account;
    private final double amount;
    private final String threadName;
    private final int waitTime;

    public WithdrawalThread(BankAccount account, int waitTime, double amount, String threadName) {
        this.account = account;
        this.amount = amount;
        this.waitTime = waitTime;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " began to run!");
        boolean exit = false;

        while (!exit) {
            try {
                Thread.sleep(waitTime * 1000);
                account.withdraw(amount, threadName);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}