package com.ethanc.listandmap;

public class Movie {
    private String name;
    private String actors;
    private double score;
    private double price;

    public Movie() {
    }
    public Movie(String name, String actors, double score, double price) {
        this.name = name;
        this.actors = actors;
        this.score = score;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
