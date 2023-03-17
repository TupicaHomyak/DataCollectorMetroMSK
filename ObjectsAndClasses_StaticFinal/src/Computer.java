public class Computer {
    public Display display;
    public Hdd hdd;
    public Keyboard keyboard;
    public Processor processor;
    public Ram ram;
    public final String vendor;
    public final String name;

    public Computer(Display display, Hdd hdd, Keyboard keyboard, Processor processor, Ram ram, String vendor, String name) {
        this.display = display;
        this.hdd = hdd;
        this.keyboard = keyboard;
        this.processor = processor;
        this.ram = ram;
        this.vendor = vendor;
        this.name = name;
    }
    public void getTotalWeight()  { //Общий вес компьютера:
        double totalWeight = processor.getWeight() +
                             display.getWeight() +
                             ram.getWeight() +
                             hdd.getWeight() +
                             keyboard.getWeight();
        System.out.println("Общий вес компьютера: " + totalWeight);
    }

    public String toString() {      //вывод информации в консоль
            System.out.println("Имя компьютера: " + name);
            System.out.println("Производитель: " + vendor);
            System.out.println("Характеристики компьютера: ");
            System.out.println("Характеристики процессора: " +
                                "частота - " + processor.getFrequency() + "GHz" +
                                ", количество ядер - " + processor.getCores() +
                                ", вес - " + processor.getWeight() + "кг." +
                                ", производитель - " + processor.getManufacturer());
            System.out.println("Характеристики экрана: " +
                                "диагональ - " + display.getDiagonal() + " дюймов" +
                                ", тип - " + display.getType() +
                                ", вес - " + display.getWeight() + "кг.");
            System.out.println("Характеристики оперативной памяти: " +
                                "тип - " + ram.getType() +
                                ", объем - " + ram.getVolume() + "Gb" +
                                ", вес - " + ram.getWeight() + "кг.");
            System.out.println("Характеристики накопителя информации: " +
                                "объем памяти - " + hdd.getMemory() + "Tb" +
                                ", тип - " + hdd.getType() +
                                ", вес - " + hdd.getWeight() + "кг.");
            System.out.println("Характеристики клавиатуры: " +
                                "вес - " + keyboard.getWeight() + "кг." +
                                ", тип - " + keyboard.getType() +
                                ", наличие подсветки - " + keyboard.illumination);
        return null;
    }
    public Display getDisplay() {return display;}
    public Hdd getHdd() {return hdd;}
    public Keyboard getKeyboard() {return keyboard;}
    public Processor getProcessor() {return processor;}
    public Ram getRam() {return ram;}
    public String getVendor() {return vendor;}
    public String getName() {return name;}

    public void setDisplay(Display display) {
        this.display = display;
    }
    public void setHdd(Hdd hdd) {
        this.hdd = hdd;
    }
    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
    public void setRam(Ram ram) {
        this.ram = ram;
    }
}


