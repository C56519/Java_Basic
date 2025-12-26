package com.ethanc.testdemo;

// 练习题
/*
某加油站为了吸引更多的车主，推出了如下活动，车主可以办理金卡和银卡。

1. 卡片信息包括：车牌号码、车主姓名、电话号码、卡片余额。

2. 金卡办理入存金额必须≥5000元，银卡办理时预存金额必须≥2000元，金卡支付时享受8折优惠，银卡支付时享受9折优惠。金卡消费满200元可以提供打印免费洗车票的服务。

3. 需求：请使用面向对象编程，完成该加油站支付机的存款和消费程序。
*/

public class Test {
    public static void main(String[] args) {
        // 金卡
        Card goldCard = new GoldCard("京A88888", "刘强东", 223456789, 5000);
        // 消费500
        double debit1 = 500;
        // 刷卡
        payMachine(goldCard, debit1);


        // 银卡
        Card sliverCard = new SliverCard("粤A88888", "马化腾", 2135234543, 500);
        // 消费1000
        double debit2 = 1000;
        // 刷卡
        payMachine(sliverCard, debit2);
        // 余额不足，存钱
        sliverCard.recharge(2000);
        // 再刷卡
        payMachine(sliverCard, debit2);
    }

    // 刷卡机：可接受金卡和银卡
    public static void payMachine(Card card, double debit) {
        System.out.println("请刷卡：");
        card.debit(debit);
    }
}
