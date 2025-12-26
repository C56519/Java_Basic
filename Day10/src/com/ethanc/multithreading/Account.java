package com.ethanc.multithreading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String accountNum;
    private double balance;

    // 3 Lock锁对象
    private final Lock lc = new ReentrantLock();

    public Account() {
    }
    public Account(String accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }
    public String getAccountNum() {
        return accountNum;
    }
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 2 同步方法：
    // public synchronized void drawMoney(double money) {...}
    public void drawMoney(double money) {
        // 获取当前线程名
        String threadName = Thread.currentThread().getName();
        // 3 Lock锁，上锁
        // lc.lock();

        // 1 同步代码块：
        synchronized (this) {
            if (balance >= money) {
                this.balance -= money;
                System.out.println(threadName + "取钱成功，取钱金额：" + money + "，余额为：" + balance);
                // 3 Lock锁，解锁
                // lc.unlock();
            } else {
                System.out.println(threadName + "取钱失败，余额不足！");
            }
        }

    }
}
