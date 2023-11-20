package org.example;

import java.io.File;

public class FilesSearch { // класс для обхода папок и поиска файлов
    private final String folderPath = "data/"; // путь к папкам, которые необходимо обойти
    private String JSONFilesAbsolutePath; // пути ко всем найденным файлам JSON
    private String CSVFilesAbsolutePath; // пути ко всем найденным файлам CSV

    public FilesSearch() {
        getJSONfiles(folderPath);
        getCSVfiles(folderPath);
    }
    public String getJSONFilesAbsolutePath() {
        return JSONFilesAbsolutePath;
    }
    public String getCSVFilesAbsolutePath() {
        return CSVFilesAbsolutePath;
    }

    private String getJSONfiles(String folderPath) { //поиск всех файлов с расширением ".json"
        JSONFilesAbsolutePath = ""; //пока пусто
        File folder = new File(folderPath);
        // далее проверяем, является ли файлом,  и имеет ли нужное нам расширение
        if (folder.isFile() && folder.getName().endsWith(".json")) {
            //если да, добавляем путь к нему
            JSONFilesAbsolutePath += folder.getAbsolutePath() + "\n";
        }
        try {
            File[] files = folder.listFiles(); //объект оказался не файлом
            for (File file : files) {
                JSONFilesAbsolutePath += getJSONfiles(file.getAbsolutePath());
            }
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return JSONFilesAbsolutePath; //список путей к найденным файлам с расширением ".json".
    }

    private String getCSVfiles(String folderPath) { //  работает аналогично с getJSONfiles
        CSVFilesAbsolutePath = "";
        File folder = new File(folderPath);
        if (folder.isFile() && folder.getName().endsWith(".csv")) {
            CSVFilesAbsolutePath += folder.getAbsolutePath() + "\n";
        }
        try {
            File[] files = folder.listFiles();
            for (File file : files) {
                CSVFilesAbsolutePath += getCSVfiles(file.getAbsolutePath());
            }
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return CSVFilesAbsolutePath;
    }

}