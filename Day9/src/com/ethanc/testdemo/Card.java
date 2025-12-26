package com.ethanc.testdemo;

public class Card {
    private String point;   // 点数
    private String color;   // 花色
    private int weight;     // 权重

    public Card() {
    }
    public Card(String point, String color, int weight) {
        this.point = point;
        this.color = color;
        this.weight = weight;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // 重写toString()方法，保证按照点数+花色输出
    @Override
    public String toString() {
        return this.point + this.color;
    }
}
