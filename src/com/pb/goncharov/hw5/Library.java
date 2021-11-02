package com.pb.goncharov.hw5;

public class Library {

    public static void main(String[] args) {
        int razmerMassiva = 3;
        // используем конструктор с вводом полей сразу при создании объекта
        Book[] book = new Book[razmerMassiva];
        book[0] = new Book("Назад в будущее", "Джеймс Фокс", 1915);
        book[1] = new Book("Звездные войны", "Лукас", 2001);
        // используем конструктор без ввода полей и сеттерами задаем переменные
        book[2] = new Book();
        book[2].setBookAuthor("Тарантино");
        book[2].setBookYear(1988);
        book[2].setBookName("От заказат до рассвета");
        // сразу заполняем поля при создании объекта
        Reader[] reader = new Reader[razmerMassiva];
        reader[0] = new Reader("Сергеев", 100001, "исторический",
                "01.01.1980", 123456789);
        reader[1] = new Reader("Семенов", 200002, "химический",
                "02.02.1977", 234567891);
        reader[2] = new Reader("Симаков", 300003, "механический",
                "03.03.2001", 345678912);


        // печатаются все книги
        System.out.println("Печатаются все книги ");
        for (int i = 0; i < razmerMassiva; i++) {
            System.out.println(book[i].getBookName() + " " + book[i].getBookAuthor() + " " + book[i].getBookYear());
        }
        // печатаются все читатели
        System.out.println("Печатаются все читатели ");
        for (int i = 0; i < razmerMassiva; i++) {
            System.out.println(reader[i].getReaderFIO()+ " " + reader[i].getReaderBirth() +
                    " " + reader[i].getReaderPhone()+ " " + reader[i].getReaderFacultet() +
                    " " + reader[i].getReaderNumber()) ;
        }

        //  bookOut = true, если выдаем книгу, не было в задании для логики в методке takeBook
        reader[0].setBookOut(true) ;
        // вызывается метод takeBook, который принимает кол-во взятых книг, у нас это 15 шт

        reader[0].takeBook(15);
        // перегружаем метод takeBook, теперь он принимает переменное количество названий книг, берем книги
        // из первого обекта и второго объекта

        reader[0].takeBook(book[0].getBookName(), book[1].getBookName());

        // перегружаем метод takeBook, теперь он принимает переменное количество объектов Book
        // и печатает в формате: Приключения (Иванов И. И. 2000 г.)

        reader[0].takeBook(book[2], book[1], book[0]);

      // устанавливаем признак возврата книги
        reader[0].setBookOut(false) ;
        // вызывается метод returnBook, который принимает кол-во возвращенных книг, у нас это 7 шт

        reader[0].returnBook(7);

        // вызывается перегпуженный метод returnBook, который принимает переменное кол-во названий возвращенных книг

        reader[0].returnBook(book[2].getBookName(), book[0].getBookName(), book[1].getBookName());

        // вызывается перегпуженный метод returnBook, который принимает переменное кол-во объектов возвращенных книг

        reader[0].returnBook(book[2], book[0]);
    }
}




