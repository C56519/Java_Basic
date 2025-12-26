package com.ethanc.multithreading;
import java.util.List;

public class PeopleGetRedPacked extends Thread{
    private List<Integer> redPackets;
    public PeopleGetRedPacked(List<Integer> redPackets, String name){
        super(name);
        this.redPackets = redPackets;
    }

    @Override
    public void run() {
        while (redPackets != null) {
            synchronized (redPackets) {
                // 给每个人随机生成一个索引，对应抢红包列表中的位置
                int index = (int)(Math.random() * redPackets.size());
                // 从红包列表中删除对应位置的红包
                Integer money = redPackets.remove(index);
                System.out.println(Thread.currentThread().getName() + "抢到红包：" + money);
            }
        }
    }
}
