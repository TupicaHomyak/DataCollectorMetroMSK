package org.example;

public class Line {
    //Класс линии московского метро (имя и номер линии)
    private String name;
    private String number;

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Line{" + "name='" + name + '\'' + ", number='" + number + '\'' + '}';
    }
}