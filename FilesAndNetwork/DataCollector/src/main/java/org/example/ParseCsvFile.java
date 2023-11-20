package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParseCsvFile {
    private List<String> csvLines; //список строк из CSV-файлов
    private List<StationDate> stationsDates; //список объектов типа StationDate

    public ParseCsvFile() {
        parse();
        listFormatted();
    }
    public List<StationDate> getStationsDates() {
        return stationsDates;
    }

    private List<String> getCsvInLines() {
        List<String> lines;
        csvLines = new ArrayList<>();
        FilesSearch filesSearch = new FilesSearch();
        String[] paths = filesSearch.getCSVFilesAbsolutePath().split("\n");
        for (String path : paths) { //перебирает каждый путь,
            try {
                lines = Files.readAllLines(Path.of(path)); // читает все строки из файла,
                lines.remove(0); // удаляет первую строку,
                csvLines.addAll(lines); // добавляет оставшиеся строки в список csvLines
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvLines;
    }

    private void parse() { //
        stationsDates = new ArrayList<>(); //
        List<String> lines = getCsvInLines();
        for (String line : lines) { //перебираем каждую строку
            String[] tokens = line.split(","); // разбиваем запятыми
            if (tokens.length != 2) { // если длина разбитой строки не равна 2
                System.out.println("Wrong line = " + line);// сообщение об ошибке
            }
            stationsDates.add(new StationDate(tokens[0], tokens[1]));
        }
    }

    private void listFormatted() { //
        for (int i = 0; i < stationsDates.size(); i ++) { //
            // у каждого объекта сравнивается его имя и дата
            // с именем и датой каждого другого объекта
            String name = stationsDates.get(i).getName();
            String date = stationsDates.get(i).getDate();
            for (int j = 0; j <stationsDates.size(); j++) {
                String anotherName = stationsDates.get(j).getName();
                String anotherdate = stationsDates.get(j).getDate();
                //если найдено совпадение, метод удаляет объект с наименьшим индексом
                if (name.equals(anotherName) && date.equals(anotherdate)) {
                    stationsDates.remove(j);
                }
            }
        }
    }
}