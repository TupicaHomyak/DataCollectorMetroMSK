import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Company {
    protected List<Employee> employees;
    protected final int COMPANY_REVENUE  = 21004005;
    public Company() {
        employees = new ArrayList<>();
    }

    // два метода, возвращающие список указанной длины (count):
    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort(Comparator.comparingDouble(Employee::getMonthSalary).reversed());
        return sortedEmployees.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort(Comparator.comparingDouble(Employee::getMonthSalary));
        return sortedEmployees.subList(0, count);
    }

    public void  hire(Employee employee) { //найм одного сотрудника
        employees.add(employee);
    }
    public void hireAll(Collection<Employee> employes){ //найм списка сотрудников
        this.employees.addAll(employees);
    }
    public void fire(Employee employee){ //увольнение сотрудника
        employees.remove(employee);
    }
    public int getIncome(){ //получение значения дохода компании
        return COMPANY_REVENUE;
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public int getEmployeesCount() {
        return employees.size();
    }

}


