package com.pb.goncharov.hw12;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBook  {
    public static String file_phonebook = "/home/drag/IdeaProjects/JavaHomeWork/src/com/pb/goncharov/hw12/phonebook.json";
    // создаем переменную абонента и пустой список для книги, нужен доступ из разных методов
    static Abonent tempAbonent;
    static List<Abonent> abonents = new ArrayList<>();
    static List<Abonent> abonentsByName = new ArrayList<>();
    static List<Abonent> abonentsByPhone = new ArrayList<>();




    public static void main(String[] args) throws Exception {

        System.out.println("Приложение телефонная книга \n");

        if (Files.exists(Paths.get(file_phonebook))) {
            System.out.println("Файл телефонной книги уже существует, загружаем \n" + file_phonebook );
            abonents = jsonToAbonents(readFromFile());
        }
            else
            {
                System.out.println("Файла телефонной книги не обнаружено");
            }


                String menu = "Телефонная книга \nДля продолжения работы нажмите английскую букву: \n" +
                "A - добавить абонента\nD - удалить абонента \nF - поиск абонента \nN - вывод телефонной книги," +
                " отсортированной по имени \nP - вывод телефонной книги, отсортированной по первому телефону" +
                "\nE - редактирование абонента \nW - выгрузка книги в файл \nR - чтение книги из файла \nQ - выход";

        while (true) {

            System.out.println(menu);
            Scanner inPut = new Scanner(System.in);
            String choice = inPut.nextLine().substring(0,1).toUpperCase(Locale.ROOT);
            switch (choice) {
                case "A":
                    createNewAbonent();
                    break;
                case  "D":
                    System.out.println("Введите ID абонента, которого нужно удалить из базы \n");
                    String sss = inPut.nextLine();
                    if (abonentToFind(sss)>=0) {
                     abonentToDelete(abonentToFind(sss));
                    }
                    break;
                case  "E":
                    System.out.println("Введите ID абонента, данные которого нужно отредактировать \n");
                    String siss = inPut.nextLine();
                    if (abonentToFind(siss)>=0) {
                        abonentToEditExisting(abonentToFind(siss));
                    }
                    break;
                case "N":
                    sortByName();
                    System.out.println(abonentsByName);
                    break;
                case "P":
                    sortByFirstPhone();
                    System.out.println(abonentsByPhone);
                    break;
                case "F":
                    System.out.println("Введите строку для поиска (имя, фамилия, телефон, дата, можно не полностью) \n");
                    String sos = inPut.nextLine();
                    abonentSearch(sos);
                    break;
                case "R":
                    if (Files.exists(Paths.get(file_phonebook))) {
                        System.out.println("Файл телефонной книги уже существует, загружаем \n" + file_phonebook );
                        abonents = jsonToAbonents(readFromFile());
                    }
                    else
                    {
                        System.out.println("Файла телефонной книги не обнаружено");
                    }

                    break;
                case "W":
                    writeToFile(abonentsToJson(abonents));
                    break;
                case "Q": return;
            }
        }
}

    static Abonent abonentToEdit() {
        Scanner inPut = new Scanner(System.in);
        Abonent abon = new Abonent();
        System.out.println("Добавляем/редактируем абонента \nВведите ФИО ");
        //ловим любое исключение
        try {
            abon.setName(inPut.nextLine());
            System.out.println("Введите дату рождения в формате (2000-12-31)");
            String[] dateOfBirth = inPut.nextLine().split("-");

            // заносим дату рождения, три числа: год, месяц и день рождения
            abon.setBirth(LocalDate.of(Integer.parseInt(dateOfBirth[0]), Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[2])));
            System.out.println("Введите адрес проживания ");
            abon.setAdress (inPut.nextLine());
            abon.setLastModified(LocalDateTime.now());
            System.out.println("Введите номера телефонов абонента, например: 0676220000-0506220001-0636220000");
            String[] phones = inPut.nextLine().split("-");
            for (String phone : phones) {
                PnoneNumber pn = new PnoneNumber();
                pn.setNumber(phone);
                // напишем логику через лямбду. в зависимости от номера будем присваивать поле, например
                // 050, 099 МТС, 067 Киевстар
                UnaryOperator<String> opMob = s -> {
                        switch (s.substring(0, 3)) {
                        case "050": return "MTC";
                        case "066": return "МТС";
                        case "067": return "Kyivstar";
                        case "097": return "Kyivstar";
                        case "063": return "Life";
                        default: return "оператор связи";
                    }
                };

                pn.setOperator(opMob.apply(phone));
                // не будем писать логику для описания номера
                pn.setDescription("описание номера");
                abon.phones.add(pn);
            }

        }
        catch (Exception e) {
            System.out.println("Что то пошло не так, попробуйте понять ошибку и начнем снова:");
            System.out.println(e.getMessage());

        }
        return abon;
    }

    static void abonentToEditExisting(int indexToEdit) {
        System.out.println("Вы точно хотите отредактировать данные абонента (Y да, N нет) \n"+ abonents.get(indexToEdit));
        Scanner inu = new Scanner(System.in);
        String inn = inu.nextLine().substring(0,1).toUpperCase(Locale.ROOT);

        if (inn.equals("Y")) {
            tempAbonent = abonentToEdit();
            tempAbonent.setAbonentID(indexToEdit);
            abonents.set(indexToEdit, tempAbonent);
        }
    }

    static void createNewAbonent()  {
        tempAbonent = abonentToEdit();

        //  если аррайлист пустой - первого абонента запишем под ID=0
        if (abonents.isEmpty()) {
        tempAbonent.abonentID = 0;
        }
        else {
            //находим элемент коллекции с максимальным значением abonentID, выдергиваем из обьекта максимальное
            // значение в int и присваиваем следующий номер записываемому элементу. Немного криво, но можжно будет
            //понять сколько элементов удалялось и сколько всего было уникальных записей
            tempAbonent.abonentID = Collections.max(abonents, Comparator.comparingInt(Abonent::getAbonentID)).abonentID + 1;
        }
        abonents.add(tempAbonent);
    }



    static void sortByName()  {
        abonentsByName.clear();
        abonentsByName.addAll(0, abonents);

        //Collections.sort(abonentsByName, Comparator.comparing(Abonent::getName));   // так было в hw11
        // выводим в streamAPI сортируем по имени, и потом поток загоняем обратно в arraylist
        abonentsByName = abonentsByName.stream().sorted(Comparator.comparing(Abonent::getName))
                .collect(Collectors.toList());
    }

    static void sortByFirstPhone()  {
        abonentsByPhone.clear();
        abonentsByPhone.addAll(0, abonents);

        //сортируем список по 1-му телефону абонента
        //Collections.sort(abonentsByPhone, Comparator.comparing(Abonent::theFirstPhone)); // так было в hw11

        // выводим в streamAPI сортируем по первому телефону, и потом поток загоняем обратно в arraylist
       abonentsByPhone =  abonentsByPhone.stream().sorted(Comparator.comparing(Abonent::theFirstPhone))
               .collect(Collectors.toList());
    }

    static String abonentsToJson (List<Abonent> inn) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // json с отступами в читаемом виде
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        mapper.registerModule(module);

        String outJson = mapper.writeValueAsString(inn);
        return outJson;
    }

    static List<Abonent> jsonToAbonents (String inn) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // json с отступами в читаемом виде
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // для работы с полями типа LocalDate и LocalDateTime
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);

        List<Abonent> abs = mapper.readValue(inn, new TypeReference<List<Abonent>>() {});
        return abs;
    }

    static void writeToFile (String inn) {
        // создаем новый файл в реальной папке на компе
        try (Writer writer = new FileWriter(file_phonebook, false)) {
            // записываем исходную строку в файл
            writer.write(inn);
            System.out.println("Похоже что файл записался");
            // если не получается записать файл - ловим исключение и пишем ошибку
        } catch (Exception e) {
            System.out.println("Сработало исключение, проблема с записью файла");
            System.out.println(e.getStackTrace());
        }
    }

    static String readFromFile () {
        // создаем новый файл в реальной папке на компе
        try  {
            // записываем данные из файла сразу в строку
            String inn  = new String(Files.readAllBytes(Paths.get(file_phonebook)));
            System.out.println("Похоже что файл прочитался");
            return inn;
            // если не получается прочитать файл - ловим исключение и пишем ошибку
        } catch (Exception e) {
            System.out.println("Сработало исключение, проблема с чтением файла");
            System.out.println(e.getStackTrace());
        }
         return "";
    }

    static void abonentSearch (String substr) {
/* так было без StreamAPI  в hw11
        for (Abonent temp : abonents ) {
            if (temp.toString().toLowerCase().contains(substr.toLowerCase()))  {
                System.out.println("По поиску __  " + substr + "  __ найден абонент \n" + temp);
            }

        }
*/

        // поиск элементов со StreamAPI, по сути фильтруем и выводим только объекты, в полях которых есть
        // искомая строка
        System.out.println("Найдены абоненты:");
        abonents.stream()
                .filter(x -> x.toString().toLowerCase().contains(substr.toLowerCase()))
                .forEach(System.out::println);

    }

    static int abonentToFind (String abID) {
       if (abID.matches("\\d+")) {
            int intAbID = Integer.parseInt(abID);
           int indexToFind = Collections.binarySearch(abonents, new Abonent(intAbID), Comparator.comparing(Abonent::getAbonentID));
            if (indexToFind >= 0) {
                return indexToFind;
            }
            else
            {
                System.out.println("Вы ввели ID абонента, который не существует в базе, попробуйте еще раз");
            }

        }
        else
        {
            System.out.println("Вы ввели    " + abID + "    что невозможно идентифицировать как число, попробуйте еще раз");
        }
        return -1;
    }

    static void abonentToDelete (int indexToDelete) {

        System.out.println("Вы точно хотите удалить удалить абонента (Y да, N нет) \n"+ abonents.get(indexToDelete));
        Scanner inu = new Scanner(System.in);
        String inn = inu.nextLine().substring(0,1).toUpperCase(Locale.ROOT);

        if (inn.equals("Y")) {

            abonents.remove(indexToDelete);

        }

    }

}
