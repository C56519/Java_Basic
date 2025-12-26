package com.ethanc.chapterpractice;

public class Machine {
    private String machineName;
    private MachineStatus status;

    public Machine() {}
    public Machine(String machineName, MachineStatus status) {
        this.machineName = machineName;
        this.status = status;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public MachineStatus getStatus() {
        return status;
    }

    public void setStatus(MachineStatus status) {
        this.status = status;
    }
}
