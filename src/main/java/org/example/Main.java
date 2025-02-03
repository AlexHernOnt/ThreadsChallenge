package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new DepositThread(account,1, 300,  "Thread 1 (Deposit)");
        Thread t2 = new WithdrawalThread(account,2, 200,  "Thread 2 (Withdraw)");
        Thread t3 = new WithdrawalThread(account,3,  500, "Thread 3 (Withdraw)");

        t1.start();
        t2.start();
        t3.start();
    }
}
