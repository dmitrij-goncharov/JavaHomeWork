package com.pb.goncharov.hw6;

public class Horse extends Animal {
    // в каком месте спит лошадь
    private String placeOfSlepping ;

    // конструктор
    public Horse(String food, String location, String placeOfSlepping) {
        super(food, location);
        this.placeOfSlepping = placeOfSlepping;
    }

    @Override
    public void eat() {
        //super.eat();
        System.out.println("Лошадь ест");
    }


    @Override
    public void sleep() {
        //super.sleep();
        System.out.println("Лошадь спит в " + this.placeOfSlepping);
    }

    @Override
    public void makeNoise() {
        //super.makeNoise();
        System.out.println("Лошадь ржет");
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Объект класса Лошадь";
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        // для всех объектов класса Лошадь возвращаем 3
        return 3;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        // просто сравниваем переназначенные хеш коды
        return ( obj.hashCode() == this.hashCode() );
    }

}

