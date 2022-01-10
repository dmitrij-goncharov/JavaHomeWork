package com.pb.goncharov.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ChatClientSwing extends JFrame  {
    private Socket socket;
    //private String messageToServer;
    private BufferedReader inConsole;
    private PrintWriter pw;
    // следующие поля ^ элементы формы
    private JTextField userInput;  // jtfMessage
    private JTextArea serverResponce;  //jtaTextAreaMessage



    public ChatClientSwing() throws Exception {
        this.socket = new Socket("127.0.0.1", 1234);

        PrintWriter pw = new PrintWriter(this.socket.getOutputStream(), true);

        // Задаём настройки элементов на форме
        setBounds(600, 300, 600, 500);
        setTitle("ChatClientSwing   (выйти из чата - quit или нажать х");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        serverResponce = new JTextArea();
        serverResponce.setEditable(false);
        serverResponce.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(serverResponce);
        add(jsp, BorderLayout.CENTER);
        JButton sendToServer = new JButton("Отправить");
        JPanel bottom = new JPanel(new BorderLayout());
        add(bottom, BorderLayout.SOUTH);
        bottom.add(sendToServer, BorderLayout.EAST);
        userInput = new JTextField("Введите ваше сообщение: ");
        bottom.add(userInput, BorderLayout.CENTER);
        setVisible(true);

        // обработчик события нажатия кнопки отправки сообщения
        sendToServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // если сообщение непустое, то отправляем сообщение

                String tmp = userInput.getText().trim();
                if (!tmp.isEmpty()) {
                      pw.println(tmp);

                    // фокус на текстовое поле с сообщением
                    sendToServer.grabFocus();
                }
            }
        });

        // при фокусе поле сообщения очищается
        userInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                userInput.setText("");
            }
        });

        // добавляем обработчик события закрытия окна клиентского приложения
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                    pw.println("quit");
                    System.out.println("Пользователь вышел из чата");
            }
        });

    }


    public static void main(String[] args) throws Exception {
        // Определяем номер порта, на котором нас ожидает сервер для ответа
        int portNumber = 1234;
        ChatClientSwing chatClientSwing = new ChatClientSwing();

        // Пишем, что стартовали клиент
        System.out.println("Клиент запущен,  введите quit или нажмите на крестик, для разрыва соединения и выхода из чата");
        chatClientSwing.serverResponce.append("Клиент запущен, введите quit или нажмите на крестик," +
                "  для разрыва соединения и выхода из чата " +"\n");


        // Создать поток для чтения символов из сокета
        // Для этого надо открыть поток сокета - socket.getInputStream()
        // Потом преобразовать его в поток символов - new InputStreamReader
        // И уже потом сделать его читателем строк - BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(chatClientSwing.socket.getInputStream()));

        //Thread thread1 = new Thread(chatClientSwing);
        //thread1.start();;

        String str;
        // Входим в цикл чтения, что нам ответил сервер
        while ((str = br.readLine()) != null) {
            // Если пришел ответ "quit", то заканчиваем цикл
            if (str.equals("quit")) {
                chatClientSwing.serverResponce.append("Пользователь вышел из чата" + "\n");
                System.out.println("Пользователь вышел из чата");
                br.close();
                chatClientSwing.socket.close();
                System.exit(0);
            }
            // Печатаем ответ от сервера на консоль
            chatClientSwing.serverResponce.append(str + "\n");

            System.out.println(str);
        }

    }
}
