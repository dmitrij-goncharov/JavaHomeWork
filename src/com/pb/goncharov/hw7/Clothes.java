package com.pb.goncharov.hw7;

public abstract class Clothes {
    Size clothesSize ;
    int clothesPrice ;
    String clothesColor ;

    //создаем конструктор
    public Clothes(Size clothesSize, int clothesPrice, String clothesColor) {
        this.clothesSize = clothesSize;
        this.clothesPrice = clothesPrice;
        this.clothesColor = clothesColor;
    }

    // создаем метод для описания сводных характеристик одежды
    static String clothesFeatures (Clothes clothes) {
        return ("Тип одежды: " + clothes.getClass().getSimpleName() + ", размер " + clothes.clothesSize +
                ", цвет " + clothes.clothesColor + ", цена " + clothes.clothesPrice + " usd." );
    }

    // создаем класс Tshirt (футболка) реализует интерфейсы ManClothes и WomenClothes
    static class Tshirt extends Clothes implements ManClothes, WomenClothes {

        public Tshirt(Size clothesSize, int clothesPrice, String clothesColor) {
            super(clothesSize, clothesPrice, clothesColor);
        }
        @Override
        public void dressMan() {
            System.out.println("Реализация метода dressMan() из интерфейса ManClothes ");
        }
        @Override
        public void dressWomen() {
            System.out.println("Реализация метода dressWomen()) из интерфейса WomanClothes ");
        }
    }

    // создаем класс Pants (штаны) реализует интерфейсы ManClothes и WomenClothes,
    static class Pants extends Clothes implements ManClothes, WomenClothes {

        public Pants(Size clothesSize, int clothesPrice, String clothesColor) {
            super(clothesSize, clothesPrice, clothesColor);
        }
        @Override
        public void dressMan() {
            System.out.println("Реализация метода dressMan() из интерфейса ManClothes ");
        }
        @Override
        public void dressWomen() {
            System.out.println("Реализация метода dressWomen()) из интерфейса WomanClothes ");
        }
    }

    // создаем класс Skirt (юбка) реализует интерфейс WomenClothes,
    static class Skirt extends Clothes implements WomenClothes {

        public Skirt (Size clothesSize, int clothesPrice, String clothesColor) {
            super(clothesSize, clothesPrice, clothesColor);
        }
        @Override
         public void dressWomen() {
            System.out.println("Реализация метода dressWomen()) из интерфейса WomanClothes ");
        }
    }

    // создаем класс Tie (галстук) реализует интерфейс ManClothes,
    static class Tie extends Clothes implements ManClothes {

        public Tie(Size clothesSize, int clothesPrice, String clothesColor) {
            super(clothesSize, clothesPrice, clothesColor);
        }

        @Override
        public void dressMan() {
            System.out.println("Реализация метода dressMan() из интерфейса ManClothes ");
        }
    }
}
