import static java.lang.Math.random;

public class Manager extends Company implements Employee {
    //зп складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
    private final int FIXED_SALARY = (int) Math.round(random() * (140000 - 115000) + 115000);
    private final double BONUS_PERCENT =  0.05;
    private int salary  = (int)(FIXED_SALARY + BONUS_PERCENT * COMPANY_REVENUE);


    @Override
    public int getMonthSalary() {
        return salary;
    }
}
