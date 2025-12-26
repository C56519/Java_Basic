package com.ethanc.chapterpractice;

public class SwitchOnOffImpl implements SwitchOnOffInter {
    Machine machinelist[];

    public SwitchOnOffImpl() {
    }
    public SwitchOnOffImpl(Machine[] machines) {
        this.machinelist = machines;
    }

    @Override
    public void turnOnOff(int index) {
        // 根据此电器状态来切换，如果为OFF，调整为ON，反之亦然
        MachineStatus status = machinelist[index].getStatus();
        String machineName = machinelist[index].getMachineName();
        System.out.println("当前操作的家电为：" + machineName);
        System.out.println("开始操作===============");
        MachineStatus newStatus =
                (status == MachineStatus.OFF)
                ? MachineStatus.ON
                : MachineStatus.OFF;
        machinelist[index].setStatus(newStatus);
        System.out.println("操作成功");
        System.out.println();
    }

    @Override
    public void printAllStatus() {
        // 输出所有家电的状态
        System.out.println("当前所有家电的状态为：");
        for (int i = 0; i < machinelist.length; i++) {
            System.out.println(machinelist[i].getMachineName() + "：" + machinelist[i].getStatus().toString());
        }
        System.out.println();
    }
}
