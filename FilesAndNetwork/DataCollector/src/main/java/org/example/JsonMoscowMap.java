package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.List;

public class JsonMoscowMap { // класс для создания JSON-объекта для карты метро
    private JSONObject mainObject; // главный объект JSON
    private JSONObject stationsObjectJson; // объект, информация о станциях метро по линиям
    private JSONArray linesArrayJson; // массив объектов, информация о линиях метро
    private LinkedHashMap<String, String> stationsPerLine; // информация о станциях на каждой линии

    private ParseHtmlPage parseHtmlPage = new ParseHtmlPage();
    private List<Station> stations = parseHtmlPage.getStations();
    private List<Line> lines = parseHtmlPage.getLines();

    private LinkedHashMap<String, String> getStationsPerLine() {
        stationsPerLine = new LinkedHashMap<>();
        // идем по циклу, ключ - Номер линии, значение - станции
        for (int i = 0; i < stations.size(); i++) {
            if (!stationsPerLine.containsKey(stations.get(i).getLine())) {
                stationsPerLine.put(stations.get(i).getLine(), "");
            }
            stationsPerLine.put(stations.get(i).getLine(),
                    stationsPerLine.get(stations.get(i).getLine()) + "  " + stations.get(i).getName());
        }
        return stationsPerLine;
    }

    public JsonMoscowMap() {
        createJsonObject();
    }
    public JSONObject getMainObject() {
        return mainObject;
    }

    private JSONObject createJsonObject() { // все главное здесь происходит
        String keyStations = "stations"; //две переменные -  ключи
        String keyLines = "lines";
        getStationsPerLine();
        mainObject = new JSONObject(); // - СЮДА все скинем

        stationsObjectJson = new JSONObject();
        //объект, содержащий информацию о станциях метро по линиям
        for (int i = 0; i < lines.size(); i++) {
            JSONArray stationsArray = new JSONArray();
            // в цикле получаем список станций Линии, разделяем на фрагменты по 2 пробелам
            String listStations = stationsPerLine.get(lines.get(i).getNumber()).trim();
            String[] fragments = listStations.split("\\s{2}");
            // после этого идем еще один цикл по фрагментам
            for (String fragment : fragments) {
                stationsArray.add(fragment); // каждый фрагмент отправляем в массив
            }
            // и добавляем массив JSON-объектов для станций Линии в JSON
            stationsObjectJson.put(lines.get(i).getNumber(), stationsArray);
        }

        linesArrayJson = new JSONArray();
        //массив, содержащий информацию о линиях метро
        for (int i = 0; i < lines.size(); i++) {
            // JSON-объект для хранения информации о текущей линии:
            JSONObject obj = new JSONObject();
            obj.put("number", lines.get(i).getNumber()); // на каждой итерации даем номер
            obj.put("name", lines.get(i).getName()); // и имя
            linesArrayJson.add(obj); // + объект в массив
        }
        // добавляем объекты в mainObject
        mainObject.put(keyStations, stationsObjectJson);
        mainObject.put(keyLines, linesArrayJson);
        return mainObject;
    }


}