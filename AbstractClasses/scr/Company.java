import java.util.*;

public class Company {
    private final List<Employee> employees = new ArrayList<>();

    // два метода, возвращающие список указанной длины (count):
    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employees);
        Collections.reverse(employees);
        return employees.subList(0, count);
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(employees);
        return employees.subList(0, count);
    }

    public void  hire(Employee employee) { //найм одного сотрудника
        employees.add(employee);
    }
    public void hireAll(Collection<Employee> employees){ //найм списка сотрудников
        this.employees.addAll(employees);
    }
    public void fire(Employee employee){ //увольнение сотрудника
        employees.remove(employee);
    }
    public int getIncome(){ //получение значения дохода компании
        int income = 0;
        for (Employee e : employees ){
            if (e instanceof Manager){
                income += ((Manager) e).getSales();
            }
        }
        return income;
    }
    public List<Employee> getEmployees() { //получение списка сотрудников
        return employees;
    }
    public int getEmployeesCount() { //получение длины списка сотрудников
        return employees.size();
    }


}


