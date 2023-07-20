import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        System.out.println("Доход компании: " + company.getIncome() + " руб.");

        for (int i = 0; i < 40; i++) { // Найм 40 операторов
            Operator operator = new Operator();
            company.hire(operator);
        }

        for (int i = 0; i < 30; i++) { // Найм 30 менеджеров
            Manager manager = new Manager();
            company.hire(manager);
        }

        for (int i = 0; i < 20; i++) { // Найм 20 топ-менеджеров
            TopManager topManager = new TopManager();
            company.hire(topManager);
        }

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

        int employeesToFire = company.getEmployeesCount() / 2; // Увольнение 50% сотрудников
        List<Employee> currentEmployees = new ArrayList<>(company.getEmployees());
        Collections.shuffle(currentEmployees);
        for (int i = 0; i < employeesToFire; i++) {
            company.fire(currentEmployees.get(i));
        }

        System.out.println("После увольнения 50% сотрудников:");

        List<Employee> topSalaryStaff2 = company.getTopSalaryStaff(15); //15 самых высоких зарплат
        System.out.println("Топ " + topSalaryStaff2.size() + " самых высоких зарплат в компании:");
        for (Employee employee : topSalaryStaff2) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }

        List<Employee> lowestSalaryStaff2 = company.getLowestSalaryStaff(30); //30 самых низких зарплат
        System.out.println("Топ " + lowestSalaryStaff2.size() + " самых низких зарплат в компании:");
        for (Employee employee : lowestSalaryStaff2) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
    }
}
