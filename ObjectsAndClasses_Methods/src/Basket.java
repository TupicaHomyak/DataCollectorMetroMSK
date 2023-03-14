public class Basket {
    private static int count = 0;
    private String items = "";
    private static int totalPrice = 0;
    private int limit;
    private static double totalWeight = 0; // общая масса всех товаров
    private static int totalAllPrise = 0; //
    private static int totalAllCount = 0; //

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }
    public Basket(int limit) {
        this();
        this.limit = limit;
    }
    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }
    public static int getCount() {
        return count;
    }
    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }
    public void add(String name, int price) {
        add(name, price, 1, 0.0);
    }
    public void add(String name, int price, int count) {
        add(name, price, count, 0.0);
    }
    public void add(String name, int price, int count, double weight) {  //метод add с 4-мя параметрами
        boolean error = false;
        if (contains(name)) {
            error = true;
        }
        if (totalPrice + count * price >= limit) {
            error = true;

        }
        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " +  count + " шт. - " + price+ " руб. - " + weight + " кг.";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        totalAllCount += count;
    }
    public static int getTotalAllCount() { //Общее количество всех товаров всех корзин
        return totalAllCount;
    }
    public static int getTotalAllPrise() { //Общая стоимость всех товаров всех корзин
        return totalAllPrise +=  totalPrice;
    }
    public static double getAveragePriceAllProductInBasket(){ //Средняя цена товаров во всех корзинах
         return  totalAllPrise/Basket.getTotalAllCount();
    }
    public static double getAveragePriceAllBasket(){ //Средняя стоимость корзины
        return  totalAllPrise/Basket.count;

    }
    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0.0;
        count = 0;
    }
    public static double getTotalWeight()  { //Общий вес корзины:
        return totalWeight;
    }
    public boolean contains(String name) {
        return items.contains(name);
    }
    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общий вес этой корзины: " + Basket.getTotalWeight());
            System.out.println("Общая цена этой корзины: " + totalPrice);
            System.out.println();
            System.out.println("Проверка практической работы 6.8");
            System.out.println();
            System.out.println("кол-во корзин:  " + Basket.count);
            System.out.println("Общее количество всех товаров всех корзин: " + Basket.getTotalAllCount());
            System.out.println("Общая стоимость всех товаров всех корзин: " + Basket.getTotalAllPrise());
            System.out.println("Средняя цена товаров во всех корзинах: " + Basket.getAveragePriceAllProductInBasket());
            System.out.println("Средняя стоимость корзин: " + Basket.getAveragePriceAllBasket());

        }
    }
}
