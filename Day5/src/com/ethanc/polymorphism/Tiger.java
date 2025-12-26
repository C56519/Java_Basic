package com.ethanc.polymorphism;

public class Tiger extends Animals{
    @Override
    public void run() {
        System.out.println("老虎跑的快");
    }

    public void yell(){
        System.out.println("老虎吼叫");
    }
}
