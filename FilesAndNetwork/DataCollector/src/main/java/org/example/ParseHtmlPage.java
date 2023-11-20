package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ParseHtmlPage { // класс для парсинга веб-страницы
    private String url = "https://skillbox-java.github.io/"; //ссылка на веб-страницу
    private String pathToHtml = "data/metro_moscow.html"; //путь для сохранения полученного со страницы html файла
    public List<Line> lines; //коллекция, хранящая в себе объекты класса Line
    public List<Station> stations; //коллекция, хранящая в себе объекты класса Station

    private void getHtmlPage() { //Метод загрузит HTML-страницу по ссылке url
        try {
            // подкл. к сайту  осуществляется  библиотекой Jsoup,
            // получением объекта Document, в котором будет храниться HTML-код страницы
            Document htmlFile = Jsoup.connect(url).get();
            // исп. PrintWriter  для записи полученного кода в локальный файл
            PrintWriter writer = new PrintWriter(pathToHtml);
            // outerHtml для преобразования объекта Document в строку:
            writer.write(htmlFile.outerHtml());
            writer.close();
        } catch (IOException e) { //обрабат.исключения
            e.printStackTrace();
        }
    }

    public ParseHtmlPage() {  // конструктор, вызывает метод для парсинга
        parseHtml();
    }

    private void parseHtml() { // этот метод парсит
        lines = new ArrayList<>();  // сюда будем класть итоговые данные
        stations = new ArrayList<>(); // соответственно и сюда
        File htmlFile = new File(pathToHtml); // + объект класса File,  путь  pathToHtml

        if (htmlFile.length() == 0) { //если он пустой, вызывается метод getHtmlPage()
            getHtmlPage();
        }
        try { //обрабат.исключения

            Document doc = Jsoup.parse(htmlFile, "UTF-8"); // + объект класса Document

            // выискиваем информацию о линиях
            Elements linesInfo = doc.select("span.js-metro-line"); //все элементы span с классом js-metro-line
            for (Element element : linesInfo) { // перебираем элементы
                lines.add(new Line(element.text(), element.attr("data-line"))); // и добавляем в список lines
            }
            // выискиваем информацию о станциях
            Elements stationsPerLine = doc.getElementsByClass("js-metro-stations"); //  № линии
            for (Element element : stationsPerLine) { // перебираем элементы, ищем номера линий
                Elements stationsInfo = element.getElementsByClass("single-station"); // наличие пересадки
                for (Element station : stationsInfo) { // для каждого найденного ранее элемента ищем элементы переходы
                    String name = station.getElementsByClass("name").text(); // + Station для кажд станции
                    String line = element.attr("data-line"); // название, номер, пересадкой
                    Boolean hasConnection = station.select("span.t-icon-metroln").hasAttr("title");
                    stations.add(new Station(name, line, hasConnection)); // + объекты в список
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // геттеры, вернут списки
    public List<Line> getLines() {
        return lines;
    }
    public List<Station> getStations() {
        return stations;
    }
}