package com.pb.goncharov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in); // определяем класс inn для ввода данных
        System.out.println("Программа определяет в какой из  4х диапазонов от 0 до 100 попадает введеное число. " +
                "\n Введите целое число:  " );  // сочетание \n переносит строку
        int pereme = inn.nextInt();  //присваиваем тип целого числа и запрашиваем переменную

        if ((pereme >= 0) && (pereme <= 14)) { //  проверяем что переменная в диапазоне от 0 до 14 включительно
                System.out.println("Число " + pereme + " в диапазаоне от 0 до 14 включительно"  ); // выводим результат
            }
        if ((pereme >= 15) && (pereme <= 35)) { //  проверяем что переменная в диапазоне от 15 до 35 включительно
                System.out.println("Число " + pereme + " в диапазаоне от 15 до 35 включительно"  ); //выводим результат
        }
        if ((pereme >= 36) && (pereme <= 50)) { //  проверяем что переменная в диапазоне от 36 до 50 включительно
                System.out.println("Число " + pereme + " в дипазаоне от 36 до 50 включительно"  ); // выводим результат
        }
        if ((pereme >= 51) && (pereme <= 100)) { //  проверяем что переменная в диапазоне от 51 до 100 включительно
                System.out.println("Число " + pereme + " в дипазаоне от 51 до 100 включительно"  ); //выводим результат
        }
        if ((pereme < 0) || (pereme > 100)) { // проверяем что переменная или меньше 0 или больше 100
                System.out.println("Число " + pereme + " не попадает в диапазон от 0 до 100 включительно" );
        }
    }
}