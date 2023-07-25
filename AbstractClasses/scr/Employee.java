public interface Employee extends Comparable<Employee> {
     int getMonthSalary();
     //метод, возвращающий зарплату сотрудника

     default int compareTo(Employee o) {
          return Integer.compare(getMonthSalary(), o.getMonthSalary());
     }

}
