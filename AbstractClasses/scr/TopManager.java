public class TopManager  implements Employee {
    //фикс.часть + бонус в виде 150% от заработной платы, если доход компании более 10 млн рублей.
    private final int salary = (int) (Math.random() * 80000) + 80000;
    private final Company company;
    public TopManager(Company company) {
        this.company = company;
    }
    @Override
    public int getMonthSalary() {
        if (company.getIncome() > 10000000)
            return (int) (salary * 1.5);
        return salary;
    }
}
