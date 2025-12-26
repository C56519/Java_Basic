package com.ethanc.chapterpractice;
import java.util.Scanner;

// 本章节的整合练习
// 实现一个智能家居系统的一个功能：可以让用户选择要控制的三个设备（电灯、电视机、洗衣机），以实现开关操作
public class Test {
    public static void main(String[] args) {
        // 创建电器对象类
        Machine[] machines = new Machine[3];
        machines[0] = new Light("电灯", MachineStatus.OFF);
        machines[1] = new TV("电视机", MachineStatus.OFF);
        machines[2] = new WashingMachine("洗衣机", MachineStatus.OFF);

        // 开关逻辑
        SwitchOnOffInter thisMachine = new SwitchOnOffImpl(machines);
        while (true) {
            thisMachine.printAllStatus();
            System.out.println("请选择要控制的设备：0. 电灯 1. TV 2. 洗衣机 3. 退出");
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            switch (index) {
                case 0:
                    thisMachine.turnOnOff(index);
                    break;
                case 1:
                    thisMachine.turnOnOff(index);
                    break;
                case 2:
                    thisMachine.turnOnOff(index);
                    break;
                case 3:
                    System.out.println("已退出，如有需要请重新打开控制系统");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}
