
public class Arithmetic { //класс  с переменными
    int a;
    int b;
    public Arithmetic(int a, int b) { // Конструктор  с переменными
        this.a = a;
        this.b = b;
    }
    public static int sum(int a, int b) { //Метод суммирования
        return a + b;
    }
    public static int multiplication(int a, int b) { // Метод произведения
        return a * b;
    }
    public static int maximum(int a, int b) { // Метод поиска максимального
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public static int minimum(int a, int b) { // Метод поиска минимального
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}