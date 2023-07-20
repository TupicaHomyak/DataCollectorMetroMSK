import static java.lang.Math.random;
public class TopManager extends Company implements Employee {
    private final int FIXED_SALARY  = (int) Math.round(random() * (140000 - 115000) + 115000);
    private final double BONUS_PERCENT =  1.5;
    //фикс. часть + бонус в виде 150% от заработной платы, если доход компании более 10 млн рублей.
    private int salary = (int)(FIXED_SALARY + (COMPANY_REVENUE > 10000000 ? BONUS_PERCENT * FIXED_SALARY : 0));

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
