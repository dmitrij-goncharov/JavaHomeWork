package com.pb.goncharov.hw13;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;


public class Factory {
    // набор товаров производителя
    String[] goods = new String[]{"гайка", "болт", "шестеренка", "винт", "шуруп", "втулка", "шпонка"};
    final List<String> buffer = new LinkedList<>();
    int bufferSize = 5;
    Random random = new Random();

    // создаем исполняемую в потоке лямбда функцию
    Runnable producer = () -> {
        synchronized (buffer) {
            try {
                while (true) {
                    if (buffer.size() == bufferSize) {
                        System.out.println("производитель ждет");
                        buffer.wait();
                    } else {
                        int randomIndex = random.nextInt(7);
                        System.out.println("отправил на склад " + (goods[randomIndex]));
                        buffer.add(goods[randomIndex]);
                        //sleep(400);
                        buffer.notify();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };

    // создаем исполняемую в потоке лямбда функцию
    Runnable consumer = () -> {
        synchronized (buffer) {
            try {
                while (true) {

                    if (buffer.size() == 0) {
                        System.out.println("потребитель ждет");
                        buffer.wait();
                    } else {
                        System.out.println("забрал  " + buffer.remove(buffer.size() - 1));
                        //sleep(200);

                        buffer.notify();
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };

    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory();
        Thread thread1 = new Thread(factory.producer);
        Thread thread2 = new Thread(factory.consumer);
        thread2.start();
        thread2.setName("Thread_Consumer");
        thread1.start();
        thread1.setName("Thread_Producer");
    }

}
