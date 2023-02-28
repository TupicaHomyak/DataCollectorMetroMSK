public class Elevator { //класс, эмулирующий работу пассажирского лифта
    private int currentFloor = 1; //текущий этаж (изнач. равна 1)
    private int minFloor; //минимальный этаж
    private int maxFloor; //максимальный этаж
    public Elevator(int minFloor, int maxFloor) { //Конструктор с двумя параметрами minFloor и maxFloor,
        this.minFloor = minFloor;
        this.maxFloor = maxFloor; // ???? сохраняющий эти параметры в соответствующих переменных класса.
    }
    public int getCurrentFloor() { //метод, будет возвращать текущий этаж

        return currentFloor;
    }
    public void moveDown() { //метод, перемещающий лифт на один этаж вниз
        if (currentFloor > minFloor) {
            currentFloor = currentFloor - 1;
        }
        else {
            currentFloor = currentFloor;
        }
    }
    public void moveUp() { //метод, перемещающий лифт на один этаж вверх
        if (currentFloor < maxFloor) {
            currentFloor = currentFloor + 1;
        }
        else {
            currentFloor = currentFloor;
        }
    }

    public void move(int floor) { // метод, перемещающий лифт на заданный  этаж, если он задан верно.
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Ошибка");// параметр у метода задан неверно, сообщение об ошибке.
        } else if (floor < currentFloor) {
            while (true) {
                moveDown();
                if (floor != currentFloor) {
                    System.out.println("Этаж: " + currentFloor);// выводит на конс. текущ этаж
                }
                else if (floor == currentFloor) {
                    System.out.println("Этаж: " + currentFloor);
                    break;
                }
            }
        } else if (floor > currentFloor) {
            while (true) {
                moveUp();
                if (floor != currentFloor) {
                    System.out.println("Этаж: " + currentFloor);
                }
                else if (floor == currentFloor) {
                    System.out.println("Этаж: " + currentFloor);
                    break;
                }
            }
        }
    }
}