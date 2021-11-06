package com.pb.goncharov.hw6;

import java.util.Objects;

public class Cat extends Animal {
    // какой вид корма есть кошка
    private String sortOfFeed ;

    // конструктор
    public Cat(String food, String location, String sortOfFeed) {
        super(food, location);
        this.sortOfFeed = sortOfFeed;
    }

    @Override
    public void makeNoise() {
        //super.makeNoise();
        System.out.println("Кошка мурлычет ");
    }

    @Override
    public void eat() {
        // super.eat();
        System.out.println("Кошка ест " + this.sortOfFeed);
    }

    @Override
    public void sleep() {
        //super.sleep();
        System.out.println("Кошка спит");
    }

    @Override
    public String toString() {
       // return super.toString();
        String nameOfObject = super.toString();
        // начало имени обьекта - с 21 символа, уберем названия пакетов
        // com.pb.goncharov.hw6. = 20 символов и до конца строки
        nameOfObject = nameOfObject.substring(21, nameOfObject.length());
        // вырежем кусок до символа @
        int finish = nameOfObject.length();
        for (int i=0; i < nameOfObject.length() ; i++) {
            if (nameOfObject.charAt(i) == '@') {
            finish = i;
            break;
            }
        }
        nameOfObject = nameOfObject.substring(0, finish);
        return nameOfObject;
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        // для всех объектов класса кошка возвращаем 1
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        // просто сравниваем переназначенные хеш коды
        return ( obj.hashCode() == this.hashCode() );
    }


}

