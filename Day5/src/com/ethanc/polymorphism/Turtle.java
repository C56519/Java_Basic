package com.ethanc.polymorphism;

public class Turtle extends Animals{
    @Override
    public void run() {
        System.out.println("乌龟跑的慢");
    }

    public void shirkHead() {
        System.out.println("乌龟会缩头");
    }
}
