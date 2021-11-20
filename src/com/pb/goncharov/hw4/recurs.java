package com.pb.goncharov.hw4;

public class recurs {
    //проверка работы рекурсии



    public static void main(String[] args) {


        int a = 4, b = 1 ;

        System.out.println(" первый вызов = "  + calculate2(a, b ));
    }

    // Второй вариант решения

    static int calculate2(int a, int b) {
                System.out.println("перед рекурсией  - вечный цикл  " + a + " "+ b );
        a-- ;
        if  (a > 0) {
            System.out.println("внутри рекурсии = " + calculate2(a, (b+1)) );
            System.out.println("2внутри цикла рекурсии " + a+ "номер рекурсии "+ b );
        }
        System.out.println("перед выходом из рекурсии " + a + "номер рекурсии "+ b);
        return a;
    }
}
