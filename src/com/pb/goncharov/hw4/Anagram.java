package com.pb.goncharov.hw4;
import java.util.Scanner;
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        System.out.println("Введите первое предложение ");
        Scanner input = new Scanner(System.in); // определяем input для ввода данных
        String firstSentence = input.nextLine(); // запрашиваем ввод первого предложения
        System.out.println("Введите второе предложение ");
        String secondSentence = input.nextLine(); // запрашиваем ввод второго предложения

        if (compareSentences(firstSentence, secondSentence)) {
            System.out.println("Первое предложение является анаграммой второго ");
        }
        else {
            System.out.println("Первое предложение НЕ является анаграммой второго ");
        }
    }

    // создаем метод, он принимает две строки и возвращает true - если все буквы совпадают в строках
    //
    static Boolean compareSentences (String stroka1, String stroka2) {

        String strokaOfLetters1 = "" ;     //  временная строка для первого предложения
        String strokaOfLetters2 = "" ;     // временная строка для второго предложения
        int i;                             // временная  переменная для цикла

        for (i = 0; i < stroka1.length(); i++) {
            if (Character.isLetter (stroka1.charAt(i))) {              // если символ это буква
                strokaOfLetters1 = strokaOfLetters1 + Character.toUpperCase(stroka1.charAt(i)) ;
            }                                                                     // меняем букву на заглавную букву
        }                                                                         // и добавляем в строку
        for (i = 0; i < stroka2.length(); i++) {
            if (Character.isLetter (stroka2.charAt(i))) {                        // то же самое для второго предложения
                strokaOfLetters2 = strokaOfLetters2 + Character.toUpperCase(stroka2.charAt(i)) ;
            }
        }

        char [] Array1 = strokaOfLetters1.toCharArray() ;  // создаем массив из временной строки с первым предложением
        char [] Array2 = strokaOfLetters2.toCharArray() ;  // создаем массив из временной строки со вторым предложением
        Arrays.sort (Array1) ;  // сортируем массивы
        Arrays.sort (Array2) ;
        strokaOfLetters1 = Arrays.toString(Array1) ;  // загоняем отсортированный массив обратно во временную строку
        strokaOfLetters2 = Arrays.toString(Array2) ;

        return ( strokaOfLetters1.equals(strokaOfLetters2) ) ;  // если сроки равны  возвращаем true
    }
}
