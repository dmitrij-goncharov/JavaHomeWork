package com.pb.goncharov.hw6;

public class Dog extends Animal {
    // уровень грокости лая , от 1 до 10
    private int barkingLevel ;
    // конструктор

    public Dog(String food, String location, int barkingLevel) {
        super(food, location);
        this.barkingLevel = barkingLevel;
    }

    @Override
    public void makeNoise() {
        //super.makeNoise();

        if (this.barkingLevel > 5) {
            System.out.println("Собака громко лает");
        }
            else {
                System.out.println("Собака тихо лает");
            }

    }

    @Override
    public void eat() {
        //super.eat();
        System.out.println("Собака ест ");
    }

    @Override
    public void sleep() {
        //super.sleep();
        System.out.println("Собака спит");
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Объект Класса Собака";
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        // для всех объектов класса собака возвращаем 2
        return 2;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        // просто сравниваем переназначенные хеш коды
        return ( obj.hashCode() == this.hashCode() );
    }

}
