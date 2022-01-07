package com.pb.goncharov.hw14;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiServer {

    private ArrayList<Connection> connections = new ArrayList<Connection>();
    int port = 1234;


    public MultiServer() {
        //Socket socket = null;
        //ServerSocket serverSocket = null;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен порту " + port);
            ExecutorService threadPool = Executors.newFixedThreadPool(10);
            // В цикле ждем запроса клиента
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Connection connection = new Connection(clientSocket, this);
                connections.add(connection);
                threadPool.submit(connection);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    // отправляем сообщение всем клиентам
    public synchronized void sendToAll(String outText) {
        //System.out.println(outText);
        for (Connection conn : connections) {
            conn.sendMsg(outText);
        }
    }

    // удаляем соединение из аррейлиста при выходе из чата
    public synchronized void removeСonn(Connection conn) {
        connections.remove(conn);
    }

    public static void main(String[] args) {
        MultiServer multiServer = new MultiServer();
    }

    public class Connection implements Runnable {
        // экземпляр нашего сервера
        private MultiServer server;
        // исходящее сообщение
        private PrintWriter outMess;
        // входящее собщение
        private Scanner inMess;
        private static final String HOST = "localhost";
        private static final int PORT = 1234;
        // клиентский сокет
        private Socket clientSocket = null;


        // конструктор, который принимает клиентский сокет и сервер
        public Connection(Socket socket, MultiServer server) {
            try {

                this.server = server;
                this.clientSocket = socket;
                this.outMess = new PrintWriter(socket.getOutputStream());
                this.inMess = new Scanner(socket.getInputStream());
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

        // Переопределяем метод run(),
        //
        @Override
        public void run() {
            try {
                while (true) {
                    // сервер отправляет сообщение
                    System.out.println("Подключился новый пользователь: " + Thread.currentThread().getName());
                    sendToAll("Подключился новый пользователь: " + Thread.currentThread().getName());
                    break;
                }
                String out ;

                while (true) {
                    // Если от клиента пришло сообщение
                    if (inMess.hasNext()) {
                        String clientMessage = inMess.nextLine();
                        // если клиент отправляет данное сообщение, то цикл прерывается и
                        // клиент выходит из чата
                        if (clientMessage.equalsIgnoreCase("quit")) {
                            this.sendMsg("quit");
                            sendToAll("Вышел из чата " + Thread.currentThread().getName());
                            System.out.println("Вышел из чата " + Thread.currentThread().getName());
                            break;
                        }
                        // выводим в консоль сообщение (для теста)
                        out = (LocalDateTime.now() + " " + clientMessage);
                        System.out.println(out);
                        // отправляем данное сообщение всем клиентам
                        sendToAll(out);
                    }
                    // останавливаем выполнение потока на 100 мс
                    Thread.sleep(50);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                this.close();

            }
        }

        // отправляем сообщение
        public void sendMsg(String msg) {
            try {
                outMess.println(msg);
                outMess.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // клиент выходит из чата
        public void close() {
            // удаляем клиента из списка

            removeСonn(this);
        }


    }

}
