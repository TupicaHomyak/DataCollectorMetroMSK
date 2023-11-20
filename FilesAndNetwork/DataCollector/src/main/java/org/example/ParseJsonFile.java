package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonFile { //класс для парсинга файлов формата JSON
    private List<String> jsonString; // список содержимого JSON-файлов в виде строк
    private List<StationDepth> stationsDepth; // список с информацией о глубине станций

    public ParseJsonFile() {
        parse();
        listFormatted();
    }
    public List<StationDepth> getStationsDepth() {
        return stationsDepth;
    }

    // метод возвращает список JSON-строк из файлов с расширением .json
    private List<String> getJsonInString() {
        jsonString = new ArrayList<>(); // список с содержимым JSON-файлов в виде строк
        FilesSearch filesSearch = new FilesSearch(); // объект ранее созданного класса
        // благодаря ему получим строковый массив путей к json-файлам
        String[] paths = filesSearch.getJSONFilesAbsolutePath().split("\n");

        for (String path : paths) { // читаем содержимое каждого файла
            try {
                // результат в виде строки добавляется в список
                jsonString.add(Files.readString(Paths.get(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonString;
    }

    private void parse() { // парсинг данных из JSON-файлов
        stationsDepth = new ArrayList<>();
        JSONParser jsonParser = new JSONParser(); // объект ранее созданного класса
        try {
            // переберем полученные строки и парсим в JSONArray
            for (String string : getJsonInString()) {
                JSONArray jsonData = (JSONArray) jsonParser.parse(string);
                // для каждого JSON-объекта парсится информация о станциях - название и глубину
                for (Object infoDepth : jsonData) {
                    JSONObject stationDepth = (JSONObject) infoDepth;
                    String name = (String) stationDepth.get("station_name");
                    String depth = (String) stationDepth.get("depth");
                    // формат хар-ки глубины делаем одинаковым:
                    String depth1 = depth.replaceAll(",", ".");
                    String depth2 = depth1.replaceAll("\\?", "-0");
                    //
                    stationsDepth.add(new StationDepth(name, depth2));
                }
            }
        } catch (ClassCastException e) {
            e.getStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    private void listFormatted() { // удалим дубликаты станций, оставим с наибольшей глубиной
        for (int i = 0; i < stationsDepth.size(); i++) { //перебираем список станций
            String name = stationsDepth.get(i).getName(); // получаем Имя
            Double depth = Double.parseDouble(stationsDepth.get(i).getDepth()); // получаем Глубину
            for (int j = 0; j < stationsDepth.size(); j++) { //перебираем элементы списка stationsDepth еще раз
                String anotherName = stationsDepth.get(j).getName();
                Double anotherDepth = Double.parseDouble(stationsDepth.get(j).getDepth());
                String sameName1 = "Смоленская"; // станции со сдвоенным названием
                String sameName2 = "Арбатская";
                //Если имена текущей и другой станций равны и они не равны значениям sameName:
                if (name.equals(anotherName) && !name.equals(sameName1) && !name.equals(sameName2)) {
                    if (depth.compareTo(anotherDepth) > 0) {// глубина текущей станции больше глубины другой станции
                        stationsDepth.remove(j); // другая станция удаляется
                    } else {
                        stationsDepth.remove(i); // или же текущая станция
                    }
                }
            }
        }
    }
}