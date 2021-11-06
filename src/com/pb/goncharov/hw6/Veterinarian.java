package com.pb.goncharov.hw6;

public class Veterinarian {
    String str ;

    public Veterinarian(String str) {
        this.str = str;
    }

    void treatAnimal(Animal animal) {
        System.out.println("Животное: " + animal.toString() + " ест: " + animal.getFood() +
                " находится: " + animal.getLocation());
        }
}
