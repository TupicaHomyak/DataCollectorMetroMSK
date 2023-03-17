public class Main {
    public static void main(String[] args) {

        //создаем параметры для всех характеристик (1)
        Display display1 = new Display(16.0, 3.9, DisplayType.IPS);
        Hdd hdd1 = new Hdd(0.6,1000,HddType.SSD);
        Keyboard keyboard1 = new Keyboard(0.5,true, KeyboardType.MEMBRANE);
        Processor processor1 = new Processor(3.20, 8, 0.1, "AMD");
        Ram ram1 = new Ram(0.4,16, RamType.DDR_SDRAM);

        //создаем параметры для всех характеристик (2)
        Display display2 = new Display(16.0, 4.5, DisplayType.TN);
        Hdd hdd2 = new Hdd(0.5,1500,HddType.HDD);
        Keyboard keyboard2 = new Keyboard(0.3,false, KeyboardType.SCISSOR);
        Processor processor2 = new Processor(3.4, 8, 0.1, "Intel");
        Ram ram2 = new Ram(0.3,16, RamType.SDR_SDRAM);

        //создаем компьютер 1
        Computer computer1 = new Computer(display1, hdd1, keyboard1, processor1, ram1, "Asus", "Homyak-Compukter" );
        //создаем компьютер 1
        Computer computer2 = new Computer(display2, hdd2, keyboard2, processor2, ram2, "Asis", "Andra-Compukter" );


        // проверяем работу методов
        System.out.println("проверяем метод вывода информации о компьюторе 1");
        computer1.toString();
        System.out.println();
        System.out.println("проверяем метод вывода информации о компьюторе 2");
        computer2.toString();
        System.out.println();
        System.out.println("проверяем метод вывода информации о весе компьютера 1");
        computer1.getTotalWeight();
        System.out.println();
        System.out.println("проверяем метод вывода информации о весе компьютера 2");
        computer2.getTotalWeight();



    }
}