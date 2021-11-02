package com.pb.goncharov.hw5;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int bookYear;

    // конструктор без ввода переменных
    public Book() {
    }

    // конструктор с вводом переменных
    public Book(String bookName, String bookAuthor, int bookYear) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }
    // сеттеры
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }


    // геттеры
    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }


}

