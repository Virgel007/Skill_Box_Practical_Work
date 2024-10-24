import java.text.NumberFormat;

public class Manager implements Employee {
    private final NumberFormat numberFormat = NumberFormat.getInstance();
    private final double salary;

    public Manager(Company company) {
        salary = company.getBaseSalary();
    }

    @Override
    public double getMonthSalary() {
        double bonusSalaryManager = 1.05;
        return salary * bonusSalaryManager;
    }

    @Override
    public String toString() {
        return "Менеджер: " + numberFormat.format((int) getMonthSalary())  + " руб.";
    }
}