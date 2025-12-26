package com.ethanc.abstractclass;

public class Tiger extends Animal {
    public Tiger() {
    }
    public Tiger(String name) {
        super(name);
    }
    @Override
    public void yell() {
        System.out.println("虎啸山林");
    }
}
