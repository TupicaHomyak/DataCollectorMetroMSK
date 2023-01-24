public class Main {
    public static void main(String[] args) {
// для проверки класса Basket

        Basket vasyaBasket = new Basket();
        vasyaBasket.add("молоко", 55, 2);
        vasyaBasket.add("хлеб", 33, 3);
        vasyaBasket.print("Корзина Васи: ");
        System.out.println();

        Basket petyaBasket = new Basket();
        petyaBasket.add("молоко", 55, 2, 0.3);
        petyaBasket.add("авокадо", 100, 10, 0.2);
        petyaBasket.add("кола", 130,4, 2.0);
        petyaBasket.print("Корзина Пети: ");

// для проверки класса Arithmetic
        System.out.println();
        System.out.println( "Сумма чисел = " + Arithmetic.sum(2, 8));
        System.out.println( "Произведение чисел  = " + Arithmetic.multiplication(2, 8));
        System.out.println( "Максимальное из двух чисел = " + Arithmetic.maximum(2, 8));
        System.out.println( "Минимальное из двух чисел = " + Arithmetic.minimum(2, 8));
    }
}
