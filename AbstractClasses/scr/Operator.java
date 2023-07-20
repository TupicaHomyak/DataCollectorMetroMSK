import static java.lang.Math.random;

public class Operator extends Company implements Employee {
    //Operator — зарплата складывается только из фиксированной части.
    private int salary = (int) Math.round(random() * (140000 - 115000) + 115000);

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
