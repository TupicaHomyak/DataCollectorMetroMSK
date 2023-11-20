package org.example;

public class StationDepth {
    // Класс глубины станции (имя, глубина)
    // - из JSON файлов, из архива data
    private String name;
    private String depth;

    public StationDepth(String name, String depth) {
        this.name = name;
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public String getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "StationDepth{" + "name='" + name + '\'' + ", depth='" + depth + '\'' + '}';
    }
}