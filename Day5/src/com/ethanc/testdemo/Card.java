package com.ethanc.testdemo;

public class Card {
    private String carNumber;
    private String userName;
    private double phoneNumber;
    private double balance; //卡余额

    public Card() {}
    public Card(String carNumber, String userName, double phoneNumber, double balance) {
        this.carNumber = carNumber;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 充值
    public void recharge(double money) {
        System.out.println("充值金额是：" + money);
        balance += money;
        System.out.println("充值成功，当前余额为：" + balance);
        System.out.println();
    }
    // 扣款
    public void debit(double money) {
        balance -= money;
    }
}
