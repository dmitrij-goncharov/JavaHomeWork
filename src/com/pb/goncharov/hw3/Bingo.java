package com.pb.goncharov.hw3;

 import java.util.Random;
 import java.util.Scanner;

public class Bingo {
      public static void main(String[] args) {
          int counter = 0;  //  присваивем переменную для подсчета циклов-попыток
          int guessEnigma; //присваиваем переменную для отгадки
          Random random = new Random();
          int Enigma = random.nextInt(101); // генерируем случайное число от 0 до 100 включительно
          Scanner input = new Scanner(System.in); // определяем input для ввода данных
          System.out.println(" Отгадайте число от 0 до 100 включительно.  \n  Введите число от 0 до 100, " +
                  "любое другое число заканчивает игру: " );
              while (true) {
                  guessEnigma = input.nextInt();  // запрашиваем ввод отгадки
                  if ((guessEnigma < 0) || (guessEnigma > 100 )) {    // проверяем что число меньше 0 или больше 100
                  System.out.println("Спасибо, что выбрали Bingo :))) Вы попробовали "+ counter + " раз и не угадали");
                  break;  // надоело угадывать, выходим из цикла
                  }
                  else {
                  counter++;       // поскольку ввели число от 0 до 100 засчитываем попытку
                       if (guessEnigma == Enigma) {
                       System.out.println(" Bingo!!! Вы угадали с "+ counter + " раза!!! Было действительно " +
                          "загадано " + Enigma );
                           break;  // угадали, выходим из цикла
                       }
                       else {
                            if (guessEnigma > Enigma) {
                               System.out.println(" Загаданное число меньше, попробуйте снова");
                            }
                            else {
                               System.out.println(" Загаданное число больше, попробуйте снова");
                            }
                       }
                  }
              }
      }
}

