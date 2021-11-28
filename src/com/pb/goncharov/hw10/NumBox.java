package com.pb.goncharov.hw10;



public class NumBox <T extends Number> {
    T[] numbers;

    public NumBox(T[] numbers) {
        this.numbers = numbers;
    }

    public NumBox (int size) {
         numbers = (T[]) new Number[size];
    }


    void add(T num) throws  lenghtExeption {

        for (int i=0; i < this.numbers.length ; i++) {

            if (i == (this.numbers.length-1) && this.numbers[i] != null) {

                throw new lenghtExeption();
            }
            if (this.numbers[i] == null) {
                this.numbers[i] = num;
                break;
            }
            }
    }

    static class lenghtExeption extends Exception {

    }

    T get(int index) {
    return numbers[index];
    }

    int length() {
    return numbers.length;
    }

    double average() {
    double rez =0;
        for (int i=0; i < numbers.length ; i++) {
        rez = rez + numbers[i].doubleValue();
        }
        return (rez/numbers.length);
    }

    double sum() {
        double summ=0;
        for (int i=0; i < numbers.length ; i++) {
            summ = summ + numbers[i].doubleValue();
        }
        return summ;
    }

     T max() {
        double max =0;
        int j = 0;
        for (int i=1; i < numbers.length ; i++) {
            if (numbers[i].doubleValue() > max) {
                max = numbers[i].doubleValue();
                j=i;
            }

            }
         return numbers[j];
    }




    public static void main(String[] args) throws lenghtExeption {

        NumBox<Float> numFloat = new NumBox<>(3);
        NumBox<Integer> numInteger = new NumBox<>(4);

        try {
            numFloat.add(1.0F);
            numFloat.add(2.0F);
            numFloat.add(4F);
            //numFloat.add(5F);
            // numFloat.add(2.0F);

            numInteger.add(10);
            numInteger.add(60);
            numInteger.add(15);
            numInteger.add(20);
        }
        catch (lenghtExeption e) {
            System.out.println("Сработало исключение, проблема с записью нового элемента");
            System.out.println(e.getStackTrace());
        }

        System.out.println(numFloat.get(1));
        System.out.println(numFloat.length());
        System.out.println(numFloat.average());
        System.out.println(numFloat.sum());
        System.out.println(numFloat.max());

        System.out.println(" \n");

        System.out.println(numInteger.get(1));
        System.out.println(numInteger.length());
        System.out.println(numInteger.average());
        System.out.println(numInteger.sum());
        System.out.println(numInteger.max());

    }
}


