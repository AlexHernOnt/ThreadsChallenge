package org.example;

/**
 * A thread that periodically withdraws a specified amount from a bank account.
 */
public class WithdrawalThread extends Thread {
    private final BankAccount account;
    private final double amount;
    private final String threadName;
    private final int waitTime;

    /**
     * Constructs a WithdrawalThread.
     *
     * @param account    The bank account to withdraw from.
     * @param waitTime   The time in seconds to wait between withdrawals.
     * @param amount     The amount to withdraw each time.
     * @param threadName The name of the thread.
     */
    public WithdrawalThread(BankAccount account, int waitTime, double amount, String threadName) {
        this.account = account;
        this.amount = amount;
        this.waitTime = waitTime;
        this.threadName = threadName;
    }

    /**
     * Runs the withdrawal process, periodically withdrawing money from the account.
     */
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