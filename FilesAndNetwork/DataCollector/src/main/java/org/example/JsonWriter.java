package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter { // класс для записи нового файла
    public static void writer(JSONObject object, String path) {
        try {
            FileWriter file = new FileWriter(path); //создаем объект + путь к файлу
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(object, file); // записываем
            file.flush(); // сброс буфера
            file.close(); // и закрытие.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}