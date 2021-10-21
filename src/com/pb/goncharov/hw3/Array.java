package com.pb.goncharov.hw3;

import java.util.Scanner;

public class Array {
    public static void main (String[] args) {
        int[] array = new int[10];             // задаем массив из 10 целых чисел
        int sum = 0;                           // переменная для суммы
        int positive = 0;                      // переменная для подсчета чисел больше нуля
        Scanner in = new Scanner(System.in);

        System.out.print("Введите 10 целых чисел, которые будут элементами массива \n");
        // Заполнение массива.
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        System.out.print("Вы ввели следующий массив чисел: \n");

        // for (int ключ, массив)
        for (int anArray : array) {
            System.out.print(anArray + " ");
            sum=sum+anArray;
            if (anArray > 0) {
                positive++;
            }
        }
        System.out.print("\n" + "Сумма всех чисел равна: "+ sum );
        System.out.print("\n" + "Количество положительных элементов массива: " + positive );


        /// Сортировка пузырьком, сравниваем два элемента массива - и больший задвигаем к концу массива
        //
        int razSorted = 0 ;              // переменная razSorted считает кол-во перестановок єлементов массива в цикле
        int tmpSorted ;                  // переменная tmpSorted для замены элементов массива между собой
        int razCycle = 10 ;              // переменная razCycle для определения последнего элемента массива, который
        // подлежит сортировке
        // на старте: 10-й элемент, с каждой сортировкой будем уменьшать на 1 пузырек
        while (true) {
            for (int i = 1; i < razCycle; i++) {   // цикл начинаем со 2-го элемента массива
                if (array[i-1] > array[i]) {       // меняем єлементы массива между собой
                    tmpSorted = array[i-1] ;       // с помощью временной переменной
                    array[i-1] = array[i];         // tmpSorted
                    array[i] = tmpSorted;
                    razSorted++ ;
                }
            }
            if (razSorted == 0) {                  // если ни разу не меняли местами элементы
                break ;                            // выходим из безконечного цикла while (true)
            }
            else {
                razSorted = 0;          // обнуляем переменную, поскольку будем опять проверять/сортировать массив
            }
            razCycle-- ;                // для каждого нового цикла for,  уменьшаем индекс массива на 1 "пузырек"
            // что бы не делать лишние сравнения
        }
        System.out.print("\n" + "Отсортированный массив: \n");
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }

    }
}


