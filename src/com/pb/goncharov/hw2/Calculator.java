package com.pb.goncharov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int result ; // присваиваем тип переменной результату вычисления
        Scanner input = new Scanner(System.in); // определяем input для ввода данных
        System.out.println("Программа калькулятор позволит Вам сложить, вычесть, умножить, " +
                "разделить два целых числа \n Введите первое число " );  // сочетание \n переносит строку
        int operand1 = input.nextInt();  //присваиваем тип целого числа и запрашиваем первую переменную
        System.out.println("Введите второе число ");
        int operand2 = input.nextInt();  // присваиваем тип целого и запрашиваем вторую  переменную
        System.out.println("Введите знак действия: + - * / (только эти 4 симовола приведут к результату)");
        String sing = input.next(); // запрашиваем ввод действия, занесем его в sing

        switch (sing) {   // сравниваем sing c символами и производим операцию согласно введенного символа
            case "+" :
            result = operand1 + operand2; // складываем
                System.out.println("Результат = " + result  ); // выводим результат
             break;
            case "-" :
             result = operand1 - operand2;  // вычитаем
                System.out.println("Результат = " + result  ); // выводим результат
             break;
            case "*" :
             result = operand1 * operand2;  // умножаем
                System.out.println("Результат = " + result ); // выводим результат
             break;
            case "/" :
                if  (operand2 !=0 )  {              // проверяем не ввели ли ноль
                result = operand1 / operand2;    // не ноль, делим
                    System.out.println("Результат = " + result  ); // выводим результат
                    System.out.println("Внимание! Знак после запятой не выводится!"); //напоминаем что делим целые числа
                 }
                else  {
                System.out.println("Деление на 0 невозможно!");  // ввели ноль, объяняем что не может поделить
                 }
            break;
            default:  // ввели что то не то вместо + - * / , тогда печатаем следующую строку
            System.out.println("Неверный оператор, пожалуйста введите один из символов + - * / ");
            }
    }
}
