package com.pb.goncharov.hw8;

import java.util.regex.Pattern;

public class Auth {
    String login;
    String password;

    // пустой конструктор
    public Auth() {
    }

    // геттеры и сеттеры для всех полей
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    // метод для регистрации на сайте
    public void signUp (String log, String pass, String confir) throws WrongLoginException, WrongPasswordException {

        if (Pattern.matches("[a-zA-Z0-9]{5,20}", log)) {
          setLogin(log);
        } else {
            throw new WrongLoginException(log);
        }

        if (Pattern.matches("[a-zA-Z_0-9]{5,}",pass) && pass.equals(confir)) {
            setPassword(pass);
        }
        else {
            throw new WrongPasswordException(pass);
        }

    }

    // метод авторизации на сайте, возвращаем true если совпали логин и пароль
    public boolean signIn(String log, String pass) throws WrongLoginException  {
        if (log.equals(getLogin()) && pass.equals(getPassword())) {
           return true;
        }
        else {
            throw new WrongLoginException("===");
        }

    }

    // класс обработки WrongLoginException
    public class WrongLoginException extends Exception {
        String incorrectPassword;


        // конструкторы
        public WrongLoginException(String incorrectPassword) {
            this.incorrectPassword = incorrectPassword;
        }
        public WrongLoginException() {
        }

        String whyIncorrect() {
            // первое условие - выход по строке "===", которую присваиваем только при несовпадении логина и пароля
            if (incorrectPassword.equals("===")) {
                return "Неверно введен логин или пароль";
            }
            if (incorrectPassword.length() < 5)  {
                return "Вы ввели меньше 5 символов в поле логин";
            }
            if (incorrectPassword.length() > 20) {
                return "Вы ввели больше 20 символов в поле логин";
            }
            if  (incorrectPassword.length() < 21 || incorrectPassword.length() > 4) {
                return "Вы ввели не английские буквы и цифры от 0 до 9 в поле логин";
            }
            return "";
        }
    }

    // класс обработки WrongPasswordException
    public class WrongPasswordException extends Exception {
        String incorrectPassword;


        // конструкторы
        public WrongPasswordException(String incorrectPassword) {
            this.incorrectPassword = incorrectPassword;
        }

        public WrongPasswordException() {
        }

        String whyIncorrect() {
            if (incorrectPassword.length() < 5) {
                return "Вы ввели меньше 5 символов в поле пароля";
            } else {
                return "Вы ввели не английские буквы, знак подчеркивания и цифры от 0 до 9," +
                        " или не совпал повтор пароля";
            }
        }
    }
}
