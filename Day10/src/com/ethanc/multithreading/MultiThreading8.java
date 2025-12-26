package com.ethanc.multithreading;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/*
 * 需求
 * 红包游戏，某企业有100名员工，员工的工号依次是1, 2, 3, 4, ...到100。
 * 现在公司举办了年会活动，活动中有一个红包环节，要求共计发出200个红包，
 * 其中小红包在[1 - 30]元之间，总占比为80%，
 * 大红包[31-100]元，总占比为20%。
 *
 * 具体的功能点如下：
 *
 * 1. 系统模拟上述要求产生200个红包。
 * 2. 模拟100个员工抢红包后，需要输出哪个员工抢到哪个红包的过程，活动结束时需要提示活动结束。
 * 3. 活动结束后，请对100名员工按照所抢红包的总金额进行降序排序展示，
 *    例如：3号员工抢红包总计：293元、1号员工抢红包总计250元，...
 */
public class MultiThreading8 {
    public static void main(String[] args) {
        List<Integer> redPackets = getRedPacket();

    }

    // 模拟产生红包
    public static List<Integer> getRedPacket(){
        Random r = new Random();
        List<Integer> redPackets = new ArrayList<>();

        for (int i = 0; i < 160; i++) {
            redPackets.add(r.nextInt(30) + 1);
        }
        for (int i = 0; i < 40; i++) {
            redPackets.add(r.nextInt(70) + 31);
        }
        return redPackets;
    }
}
