package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class JsonStationsInfo { // 2ая задача: JSON-файл, содержащий информацию о станциях метро
    private JSONObject mainObject; // тот самый основной объект
    private JSONArray stationsArray;
    private String mainKey = "stations"; // ключ, под ним будет массив

    private ParseHtmlPage parseHtmlPage = new ParseHtmlPage();
    private ParseJsonFile parseJsonFile = new ParseJsonFile();
    private ParseCsvFile parseCsvFile = new ParseCsvFile();

    private List<Station> stations = parseHtmlPage.getStations();
    private List<Line> lines = parseHtmlPage.getLines();
    private List<StationDepth> stationsDepth = parseJsonFile.getStationsDepth();
    private List<StationDate> stationDates = parseCsvFile.getStationsDates();

    public JsonStationsInfo() {
        createJsonObject();
    }

    private JSONObject createJsonObject() {
        mainObject = new JSONObject();
        // массив, будет содержать объекты(станции) с полями(характеристиками):
        stationsArray = new JSONArray();
        // заполняем все поля данными из parseHtmlPage, parseJsonFile и parseCsvFile
        for (int stationIndex = 0; stationIndex < stations.size(); stationIndex++) {
            JSONObject obj = new JSONObject();
            String etalonName = stations.get(stationIndex).getName();
            obj.put("name", etalonName);

            for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
                if (stations.get(stationIndex).getLine().equals(lines.get(lineIndex).getNumber())) {
                    String nameOfLine = lines.get(lineIndex).getName();
                    obj.put("line", nameOfLine);
                }
            }
            for (int dateIndex = 0; dateIndex < stationDates.size(); dateIndex++) {
                if (stationDates.get(dateIndex).getName().equals(etalonName)) {
                    obj.put("date", stationDates.get(dateIndex).getDate());
                }
            }

            for (int depthIndex = 0; depthIndex < stationsDepth.size(); depthIndex++) {
                if (stationsDepth.get(depthIndex).getName().equals(etalonName)
                        && stationsDepth.get(depthIndex).getDepth() != "-0") {
                    obj.put("depth", stationsDepth.get(depthIndex).getDepth());
                }
            }
            obj.put("hacConnection", stations.get(stationIndex).getHasConnection());
            // после заполнения всех полей JSON-объекта он добавляется в массив stationsArray
            stationsArray.add(obj);
        }
        mainObject.put(mainKey, stationsArray);
        return mainObject;
    }
    public JSONObject getMainObject() {
        return mainObject;
    }
}