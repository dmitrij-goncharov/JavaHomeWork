package com.pb.goncharov.hw5;

public class Reader {
    private String readerFIO;
    private int readerNumber;
    private String readerFacultet;
    private String readerBirth;
    private int readerPhone;
    // добавил еще одно поле bookOut, не было в задании, для определения действия - книга выдается или возвращается
    // bookOut = true - книга выдается
    private boolean bookOut;
    //

    public Reader() {
    }

    public Reader(String readerFIO, int readerNumber, String readerFacultet, String readerBirth, int readerPhone) {
        this.readerFIO = readerFIO;
        this.readerNumber = readerNumber;
        this.readerFacultet = readerFacultet;
        this.readerBirth = readerBirth;
        this.readerPhone = readerPhone;
    }
    // для уменьшения кода setter только один, поля зададим при создания объекта

    public void setBookOut(boolean bookOut) {
        this.bookOut = bookOut;
    }


    // делаем  геттеры

    public String getReaderFIO() {
        return readerFIO;
    }

    public int getReaderNumber() {
        return readerNumber;
    }

    public String getReaderFacultet() {
        return readerFacultet;
    }

    public String getReaderBirth() {
        return readerBirth;
    }

    public int getReaderPhone() {
        return readerPhone;
    }


    // метод принимает кол-во книг и выводит на консоль
    public void takeBook(int bookQuontity) {
        if (bookOut)  {
            System.out.println ("Читатель Петров В.В. взял ");
        } else  {
            System.out.println ("Читатель Петров В.В. вернул ");
        }
        System.out.println(bookQuontity + " книг(-и)");
    }

    // перегружаем метод, Теперь он принимает переменное кол-во назвний книг
    public void takeBook(String... bookNames) {
        if (bookOut)  {
            System.out.println ("Читатель Петров В.В. взял ");
        } else  {
            System.out.println ("Читатель Петров В.В. вернул ");
        }
        for (String out : bookNames) {
            System.out.println(out);
        }
    }

    // перегружаем метод, Теперь он принимает переменное кол-во обьектов Book и выводит в
    // формате Приключения (Иванов И. И. 2000 г.)
    public void takeBook(Book... bookObjects) {
        if (bookOut) {
            System.out.println ("Читатель Петров В.В. взял ");
        } else  {
            System.out.println ("Читатель Петров В.В. вернул ");
        }
        for (Book out : bookObjects) {
            System.out.println(out.getBookName() + " (" + out.getBookAuthor() + " " + out.getBookYear() + " г.)");
        }
    }

    // создаем метод returnBook(), он будет делать тоже самое что и takeBook()
    // здесь передается кол-во книг
    public void returnBook(int bookQuontity) {
        takeBook(bookQuontity);
    }

    // перегружаем метод returnBook(), он будет делать тоже самое что и takeBook(),
    // здесь передается переменное кол-во названий книг
    public void returnBook(String... bookNames) {
        takeBook(bookNames);
    }

    // перегружаем метод returnBook(), он будет делать тоже самое что и takeBook()
    // здесь передается переменное кол-во объектов книг
    //
    public void returnBook(Book... bookObjects) {
        takeBook(bookObjects);
    }
}

