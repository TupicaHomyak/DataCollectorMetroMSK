import static java.lang.Math.random;

public class Manager implements Employee {
    //зп складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
    private int salary = (int) (Math.random() * 50000) + 50000;
    private final int sales;
    public Manager() {
        sales = (int) (Math.random() * (140000 - 115000) + 115000);
        salary += (int)(sales * 0.5);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
    public int getSales(){ // доход компании будем считать
        return sales;
    }

}
