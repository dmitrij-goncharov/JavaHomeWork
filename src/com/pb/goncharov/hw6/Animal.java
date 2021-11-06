package com.pb.goncharov.hw6;

public class Animal {
    private String food;
    private String location;

    // конструктор

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public void makeNoise () {
        System.out.println("Абстрактное животное издает звук");
    }
    
    public void eat () {
        System.out.println("Абстрактное животное ест");
    }
    
    public void sleep () {
        System.out.println("Абстрактное животное спит");
    }
}
