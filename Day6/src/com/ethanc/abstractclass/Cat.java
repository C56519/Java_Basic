package com.ethanc.abstractclass;

public class Cat extends  Animal {
    public Cat() {
    }
    public Cat(String name) {
        super(name);
    }
    @Override
    public void yell() {
        System.out.println("喵喵喵");
    }

}
