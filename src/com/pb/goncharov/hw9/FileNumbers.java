package com.pb.goncharov.hw9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {
    public static void main(String[] args) {

        createNumbersFile ();
        createOddNumbersFile ();
    }

    static void createNumbersFile () {

        // генерируем случайное число от 0 до 99 включительно
        Random random = new Random();
        int randomNumber;


        //заполняем строку из 10 случайных символов
        String outputLine ="";
        for (int j =0; j<10; j++) {
            for (int i =0; i<10; i++) {
                randomNumber = random.nextInt(100);
                outputLine = outputLine + randomNumber + " ";
            }
            outputLine = outputLine + System.lineSeparator();

        }
        //System.out.println(outputLine);

	    // создаем новый файл в реальной папке на компе
	    try (Writer writer = new FileWriter("/home/drag/IdeaProjects/JavaHomeWork/src/com/pb/goncharov/hw9/numbers.txt")) {
            // записываем исходную строку в файл
            writer.write(outputLine);
            System.out.println("Похоже что файл записался");
        // если не получается записать файл - ловим исключение и пишем ошибку
        } catch (Exception e) {
            System.out.println("Сработало исключение, проблема с записью файла");
            System.out.println(e.getStackTrace());
        }
    }
    static void createOddNumbersFile () {

        Path path = Paths.get("/home/drag/IdeaProjects/JavaHomeWork/src/com/pb/goncharov/hw9/numbers.txt");
        String oddNumbersLine ="";
        try (Scanner scan = new Scanner(path)) {

            // пока есть следующая строка , scan.hasNextLine() будет true, читаем ее из файла

            while (scan.hasNextLine()) {
                // записываем массив символов из 1-2символа , поделенных по принципу пробел
                String[] rezString = scan.nextLine().split(" ");
                // прогоняем массив через цикл
                for (String retVal : rezString) {
                    try {
                        // строчная переменная конвертируется в число и проверяется , если остаток от деления на 2
                        // этого числа равен 0, это означает что число четное, то заменяем значение на 0
                        if ((Integer.parseInt(retVal) % 2) == 0) {
                            retVal = "0";
                        }
                        // заполняем строку результат
                        oddNumbersLine = oddNumbersLine + retVal + " ";
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                }
                // добавляем в конце каждой строки символ переноса строки
                oddNumbersLine = oddNumbersLine + System.lineSeparator();

            }
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //System.out.println(oddNumbersLine);
        // создаем новый файл в реальной папке на компе
        try (Writer writer = new FileWriter("/home/drag/IdeaProjects/" +
                "JavaHomeWork/src/com/pb/goncharov/hw9/odd-numbers.txt")) {
            // записываем исходную строку в файл
            writer.write(oddNumbersLine);
            System.out.println("Похоже что файл записался");
            // если не получается записать файл - ловим исключение и пишем ошибку
        } catch (Exception e) {
            System.out.println("Сработало исключение, проблема с записью файла");
            System.out.println(e.getStackTrace());
        }
        }
}
