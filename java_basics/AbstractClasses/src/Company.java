import java.text.NumberFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Company {
    private final NumberFormat numberFormat = NumberFormat.getInstance();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Employee> topSalaryStaff = new ArrayList<>();
    private final List<Employee> lowestSalaryStaff = new ArrayList<>();
    private final String companyName;
    private double companyIncome;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public double getBaseSalary() {
        double salaryMin = 115_000;
        double salaryMax = 140_000;
        double difference = salaryMax - salaryMin;
        return (int) (salaryMin + (Math.random() * difference));
    }

    public void hire(Employee employee) {
        employees.add(employee);
        companyIncome += employee.getMonthSalary();
    }

    public void hireAll(List<Employee> employeesList) {
        employees.addAll(employeesList);
        for (int i = 0; i < getEmployees().size(); i++) {
            companyIncome += employees.get(i).getMonthSalary();
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
        companyIncome -= employee.getMonthSalary();
    }

    public double getIncome() {
        return companyIncome;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        lowestSalaryStaff.clear();
        if (employees.size() > count && count > 0) {
            employees.sort((o1, o2) -> (int) (o1.getMonthSalary() - o2.getMonthSalary()));
//            List<Employee> employeeList = employees.stream().sorted((o1, o2) -> (int) (o1.getMonthSalary() - o2.getMonthSalary())).limit(count).toList();
//            lowestSalaryStaff.addAll(employeeList);
//            employeeList.forEach(System.out::println);
            for (int i = 0; i < count; i++) {
                lowestSalaryStaff.add(employees.get(i));
            }
        } else {
            System.out.println("Error");
        }
        return lowestSalaryStaff;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        topSalaryStaff.clear();
        if (employees.size() > count && count > 0) {
            employees.sort(((o2, o1) -> (int) (o1.getMonthSalary() - o2.getMonthSalary())));
            for (int i = 0; i < count; i++) {
                topSalaryStaff.add(employees.get(i));
            }
        } else {
            System.out.println("Error");
        }
        return topSalaryStaff;
    }

    @Override
    public String toString() {
        return "Имя Фирмы: " + companyName + "\n" +
                " Количество сотрудников: " + employees.size() + "\n" +
                " Доход компании: " + numberFormat.format((int) companyIncome) + " руб.";
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}