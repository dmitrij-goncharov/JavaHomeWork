package com.pb.goncharov.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        System.out.println("Введите произвольное предложение ");
        Scanner input = new Scanner(System.in); // определяем input для ввода данных
        String smartLine = input.nextLine(); // запрашиваем ввод строки, разобраться почему отличается
        System.out.println("В каждом слове меняем первую букву на заглавную \n" + uppercase (smartLine));
    }                                                                    //   вызываем метод uppercase сразу в печати


    static String uppercase(String stroka) {        // метод принимает и возвращает строку с Заглавными буквами слов
        stroka = stroka.trim () ;                   // убираем пробелы в начале и конце строки
        String[] temp = stroka.split("\\s+") ;      // получаем массив слов из строки,
                                        // поделенный по регулярному выражению: один или более пробелов между словами
        String  returnString = "";
        for (String partof : temp ) {                     // перебираем массив полученных слов
            if (Character.isLetter (partof.charAt(0))) {                 // если первый символ слова это буква
                returnString = returnString + Character.toUpperCase(partof.charAt(0)) + partof.substring (1) + " ";
                                                                        // меняем заглавную букву вместо прописной
            }                                                           // и добавляем в строку вместе с концом слова
            else {
                returnString = returnString + partof + " ";        //если в слове первый символ это не буква,
            }                                                     // то просто добавляем это слово в строку
        }
        return  returnString.trim() ;  // убираем лишний пробел в конце строки и возвращаем переделанную строку
    }
}
