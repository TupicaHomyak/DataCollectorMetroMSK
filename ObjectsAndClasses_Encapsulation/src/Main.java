import java.util.Scanner;
public class Main {
    public static void main(String[] args) { //

        Dimensions dimensions1 = new Dimensions(5,2,3); //создаю объект класса Dimensions.
        Cargo cargo1 = new Cargo(dimensions1, 10, "Yaiva, 618340", //создаю объект класса Cargo с параметрами объекта.
                true, " 001577A", false);
        System.out.println(cargo1); //распечатываю его.
        System.out.println();


        cargo1 = cargo1.setWeight(11); //меняю параметр  класса Cargo через сеттер.
        System.out.println(cargo1); //снова тот же объект печатаю?
        System.out.println();

        Elevator elevator = new Elevator(-3, 26);// лифт в это время просто куда-то едет
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();

            elevator.move(floor);
        }
    }
}
