package com.pb.goncharov.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws Auth.WrongLoginException {

        while (true) {
            Auth auth1 = new Auth();
            Scanner inPut = new Scanner(System.in);

            // авторизация на сайте
            try {

                System.out.println("Для регистрации на сайте введите логин \n"
                        + "длинна должна быть от 5 до 20 символов, только латинские буквы и цифры" );

                String log = inPut.nextLine();
                System.out.println("Введите пароль \n"
                        + " длинна более 5, только латинские буквы и цифры и знак подчеркивания" );

                String pass = inPut.nextLine();

                System.out.println("Подтверждение пароля \n"
                        + " пожалуйста, повторите ввод пароля" );

                String conf = inPut.nextLine();

                auth1.signUp(log, pass, conf);
                System.out.println("Пользователь " + auth1.getLogin() +" с паролем ****** " +
                        "успешно зарегистирован");


            } catch (Auth.WrongLoginException exep1) {
                System.out.println(exep1.whyIncorrect());
                // System.out.println(exep.getStackTrace());
                continue;
            }
            catch (Auth.WrongPasswordException exep2) {
                System.out.println(exep2.whyIncorrect());
                continue;
            }

            // проверяем заполнили ли логин, если нет  пробуем опять
            if (auth1.getLogin() == null) {
                continue;
            }
            // вход на сайт
            try {
                System.out.println("Для входа на сайт введите логин:");
                //Scanner inPut = new Scanner(System.in);
                String log = inPut.nextLine();
                System.out.println("Для входа на сайт введите пароль");
                String pass = inPut.nextLine();
                if (auth1.signIn(log, pass)) {
                    System.out.println("Вход на сайт выплонен успешно");
                    return;
                }
            }
            catch (Auth.WrongLoginException exep3) {
                System.out.println(exep3.whyIncorrect());
                continue;
            }

        }
    }
}
