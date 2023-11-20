package org.example;

public class StationDate {
    // Класс даты открытия станций (имя, дата)
    // - из  CSV файлов, из архива data
    private String name;
    private String date;

    public StationDate (String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "StationsDates{" + "name='" + name + '\'' + ", date='" + date + '\'' + '}';
    }
}