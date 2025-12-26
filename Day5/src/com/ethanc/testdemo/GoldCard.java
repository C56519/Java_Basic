package com.ethanc.testdemo;

public class GoldCard extends Card{
    // 构造器
    public GoldCard(String carNumber, String userName, double phoneNumber, double balance) {
        super(carNumber, userName, phoneNumber, balance);
    }

    @Override
    public void debit(double money) {
        // 输出信息
        double realMoney = money * 0.8;
        double nowBalance = getBalance();
        System.out.println("本次金卡消费：" + money);
        System.out.println("优惠后的价格：" + realMoney);
        System.out.println("当前卡内余额：" + nowBalance);
        // 判断余额是否充足
        if (nowBalance < realMoney) {
            System.out.println("余额不足，请充值");
            System.out.println();
            return;
        }
        // 余额扣款
        nowBalance = getBalance() - realMoney;
        setBalance(nowBalance);
        System.out.println("=================");
        System.out.println("支付成功");
        System.out.println("当前卡内余额：" + nowBalance);

        // 金卡消费满200元可以提供打印免费洗车票的服务
        if (realMoney >= 200) {
            System.out.println("您获得一张免费洗车票");
        } else {
            System.out.println("您消费未满200，不能享受免费洗车服务");
        }
        System.out.println();
    }


}
