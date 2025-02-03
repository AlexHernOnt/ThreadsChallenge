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

public class Main {
  public static void main(String[] args) {
      BankAccount account = new BankAccount(1000);

      Thread t1 = new WithdrawalThread(account, 700, "Thread 1");
      Thread t2 = new WithdrawalThread(account, 500, "Thread 2");

      t1.start();
      t2.start();
  }
}
