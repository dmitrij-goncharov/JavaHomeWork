package com.pb.goncharov.hw7;

public class Atelier {

    public static void main(String[] args) {
        // создаем по каждому обьекту классов рубашка, брюки, юбка, галстук
        Clothes tshirt1 = new Clothes.Tshirt (Size.M, 99, "RED");
        Clothes pants1 = new Clothes.Pants (Size.XS, 55, "BLUE");
        Clothes skirt1 = new Clothes.Skirt (Size.S, 299, "ULTRAMARINE");
        Clothes tie1   = new Clothes.Tie (Size.L, 39, "BLACK");

        //создаем массив из объектов классов
        Clothes[] clothes1 =  {tshirt1, pants1, skirt1, tie1};

        // запускаем методы из этого же класса
        dressMan(clothes1);
        dressWomen(clothes1);

    }

    // метод определяет включает ли объект класса интерфейс ManClothes или WomanClothes и на основании проверки
    // определяет и печатает только параметры мужской одежды
    static void dressMan(Clothes[] clothes) {
        int i=1;
        for (Clothes temp : clothes) {
            if (temp instanceof ManClothes) {
                System.out.println("Мужская одежда: номер " + i++);
                System.out.println(Clothes.clothesFeatures(temp));
                }

        }
    }

    // метод определяет включает ли объект класса интерфейс ManClothes или WomanClothes и на основании проверки
    // определяет и печатает только параметры женской одежды
    static void dressWomen(Clothes[] clothes) {
        int i=1;
        for (Clothes temp : clothes) {
            if (temp instanceof WomenClothes) {
                System.out.println("Женская одежда: номер " + i++);
                System.out.println(Clothes.clothesFeatures(temp));
            }

        }
    }

}
