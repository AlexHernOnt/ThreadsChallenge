package org.example;

/**
 * A thread that periodically deposits money into the bank account
 */
public class DepositThread extends Thread {
    private final BankAccount account;
    private final double amount;
    private final String threadName;
    private int waitTime;

    /**
     * Constructor with parameters
     *
     * @param account    The bank account to deposit into.
     * @param waitTime   The time in seconds to wait between deposits.
     * @param amount     The amount to deposit each time.
     * @param threadName The name of the thread.
     */
    public DepositThread(BankAccount account, int waitTime, double amount, String threadName) {
        this.account = account;
        this.amount = amount;
        this.waitTime = waitTime;
        this.threadName = threadName;
    }

    /**
     * Runs the deposit process, periodically depositing money from the account.
     */
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
