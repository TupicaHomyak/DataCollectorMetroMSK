import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        System.out.println("Доход компании: " + company.getIncome() + " руб.");
        System.out.println("Численность штата: " + company.getEmployeesCount());
        System.out.println("Нанимаем 90 сотрудников:");

        List<Employee> newOperator = new ArrayList<>();// Найм списка из 40 операторов
        for (int i = 0; i < 40; i++) {
            newOperator.add(new Operator());
        }
        company.hireAll(newOperator);

        for (int i = 0; i < 30; i++) { // Найм 30 менеджеров по одному
            Manager manager = new Manager();
            company.hire(manager);
        }

        for (int i = 0; i < 20; i++) { // Найм 20 топ-менеджеров по одному
            TopManager topManager = new TopManager(company);
            company.hire(topManager);
        }

        extracted(company); //создали метод по одинаковым операциям. ого-вау

        System.out.println("Доход компании: " + company.getIncome() + " руб.");
        System.out.println("Численность штата: " + company.getEmployeesCount());

        int employeesToFire = company.getEmployeesCount() / 2; // Увольнение 50% сотрудников
        List<Employee> currentEmployees = new ArrayList<>(company.getEmployees());
        Collections.shuffle(currentEmployees);
        for (int i = 0; i < employeesToFire; i++) {
            company.fire(currentEmployees.get(i));
        }
        System.out.println("После увольнения 50% сотрудников:");

        extracted(company); //создали метод по одинаковым операциям. ого-вау

        System.out.println("Доход компании: " + company.getIncome() + " руб.");
        System.out.println("Численность штата: " + company.getEmployeesCount());
    }

    public static void extracted(Company company) {
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15); //15 самых высоких зарплат
        System.out.println("Топ " + topSalaryStaff.size() + " самых высоких зарплат в компании:");
        for (Employee employee : topSalaryStaff) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(30); //30 самых низких зарплат
        System.out.println("Топ " + lowestSalaryStaff.size() + " самых низких зарплат в компании:");
        for (Employee employee : lowestSalaryStaff) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
    }
}
