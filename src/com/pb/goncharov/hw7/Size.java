package com.pb.goncharov.hw7;

// задаем перечисление размеров одежды с переменными
public enum Size {
    //XXS, XS, S, M, L;
    XXS("Детский размер",32), XS("Взрослый размер",34),
    S("Взрослый размер",36), M("Взрослый размер",38),
    L("Взрослый размер",40);


    // конструктор description и euroSize
    private String description;
    private int euroSize;

    Size(String description, int euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    //метод возвращает строку описывающую детский или взрослый размер одежды
    String getDescription (Size inSize) {
        return  inSize.description;
    }

    // метод возвращает евроразмер в цифрах
    int getEuroSize (Size inSize) {
        return inSize.euroSize;
    }
}

