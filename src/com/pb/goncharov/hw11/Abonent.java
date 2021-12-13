package com.pb.goncharov.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Abonent   {
    int abonentID;                                   // уникальный номер абонента
    private String name;                             // фио
    private LocalDate birth;                         // дата рождения в формате 1900-12-31
    private String adress;                           // адрес проживания
    private LocalDateTime lastModified;              // дата и время последний модификации
    List<PnoneNumber> phones = new ArrayList<>();    // список телефонов абонента в виде класса PhoneNumber


    public Abonent(int abonentID) {
        this.abonentID = abonentID;
    }


    public Abonent() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public List<PnoneNumber> getPhones() {
        return phones;
    }

    public String theFirstPhone() {
        if (phones.get(0).getNumber() != null) {
            return phones.get(0).getNumber();
        }
        else {
            return "";
        }
    }


    public void setPhones(List<PnoneNumber> phones) {
        this.phones = phones;
    }

    public int getAbonentID() {
        return abonentID;
    }

    public void setAbonentID(int abonentID) {
        this.abonentID = abonentID;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "abonentID=" + abonentID + "\n" +
                "name='" + name + '\'' + "\n" +
                "birth=" + birth + "\n" +
                "adress='" + adress + '\'' + "\n"+
                "lastModified=" + lastModified + "\n" +
                "phones=" + phones +
                '}'+ "\n\n";
    }
}
