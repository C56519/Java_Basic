package com.ethanc.testdemo;

public class SliverCard extends Card{
    // 构造器
    public SliverCard(String carNumber, String userName, double phoneNumber, double balance) {
        super(carNumber, userName, phoneNumber, balance);
    }
    @Override
    public void debit(double money) {
        // 输出信息
        double realMoney = money * 0.9;
        double nowBalance = getBalance();
        System.out.println("本次银卡消费：" + money);
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
        System.out.println();
    }
}
