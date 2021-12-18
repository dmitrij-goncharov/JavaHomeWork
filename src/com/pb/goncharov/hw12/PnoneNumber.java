package com.pb.goncharov.hw12;

public class PnoneNumber {
    private String number;       //номер телефона
    private String operator;     // оператор мобильной связи, например МТС
    private String description;  //
/*
    public PnoneNumber(String number, String operator, String description) {
        this.number = number;
        this.operator = operator;
        this.description = description;
    }

    public PhoneNumber() {

    }
*/
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PnoneNumber{" +
                "number='" + number + '\'' +
                ", operator='" + operator + '\'' +
                ", description='" + description + '\'' +
                '}' + "\n";

    }
}
