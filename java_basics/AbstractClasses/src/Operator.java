import java.text.NumberFormat;

public class Operator implements Employee {
    private final NumberFormat numberFormat = NumberFormat.getInstance();
    private final double salary;

    public Operator(Company company) {
        salary = company.getBaseSalary();
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Оператор: " + numberFormat.format((int) salary) + " руб.";
    }
}