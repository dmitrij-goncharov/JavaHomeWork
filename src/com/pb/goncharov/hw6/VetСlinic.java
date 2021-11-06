package com.pb.goncharov.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {

    public static void main(String[] args) throws Exception {
        Animal anim = new Animal("растительная еда", "лес" );
        Cat   kitty = new Cat("корм", "квартира", "Вискас");
        Dog  doggy  = new Dog("кости", "дача", 9);
        Horse ponny = new Horse("сено", "ферма", "конюшня");

        Animal[] anims  = new Animal[] {kitty, doggy, ponny, anim};

        // создаем объект класса Veterinarian через рефлексию
        Class vet = Class.forName("com.pb.goncharov.hw6.Veterinarian");
        Constructor constr = vet.getConstructor(new Class[] {String.class});
        Object veterenarian = constr.newInstance("");

        // проверяем и выводим на печать работу переназначенных метдов toString(), hashCode(), equals()
        System.out.println("Объект " + anims[1].toString() + " равен объекту "+ anims[2].toString() + " "
                + anims[1].equals(anims[2]));

        // запускаем животных из массива на прием к ветеринару
        for (int i=0; i < anims.length; i++) {
             ((Veterinarian) veterenarian).treatAnimal((anims[i]));
             }
    }
}
