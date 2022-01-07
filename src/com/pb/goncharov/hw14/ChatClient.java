package com.pb.goncharov.hw14;

import java.io.*;
import java.net.Socket;

public class ChatClient implements Runnable {
    private Socket socket;
    //private String messageToServer;
    private BufferedReader inConsole;
    private PrintWriter pw;

    public ChatClient() throws Exception {
        this.socket = new Socket("127.0.0.1", 1234);
    }

    @Override
    public void run() {
        try {
            BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(this.socket.getOutputStream(), true);

            while (true) {
                // пользователь ввел сообщение и отправляем его на сервер

                pw.println(inConsole.readLine());
                }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public static void main(String[] args) throws Exception {
        // Определяем номер порта, на котором нас ожидает сервер для ответа
        int portNumber = 1234;
        ChatClient chatClient = new ChatClient();

        // Пишем, что стартовали клиент
        System.out.println("Клиент запущен,  введите quit для разрыва соединения и выхода из чата");

        // Создать поток для чтения символов из сокета
        // Для этого надо открыть поток сокета - socket.getInputStream()
        // Потом преобразовать его в поток символов - new InputStreamReader
        // И уже потом сделать его читателем строк - BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(chatClient.socket.getInputStream()));

        Thread thread1 = new Thread(chatClient);
        thread1.start();;

         String str;
        // Входим в цикл чтения, что нам ответил сервер
        while ((str = br.readLine()) != null) {
            // Если пришел ответ "quit", то заканчиваем цикл
            if (str.equals("quit")) {
                System.out.println("Вы вышли из чата");
                br.close();
                chatClient.socket.close();
                System.exit(0);
            }
            // Печатаем ответ от сервера на консоль
            System.out.println(str);
        }

    }
}
