import static java.lang.Math.random;

public class Operator  implements Employee {
    //Operator — зарплата складывается только из фиксированной части.
    private final int salary = (int) (Math.random() * 35000) + 35000;

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
