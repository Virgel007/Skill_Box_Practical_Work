import java.text.NumberFormat;

public class TopManager implements Employee {
    private final NumberFormat numberFormat = NumberFormat.getInstance();
    private final Company company;
    private final double salary;

    public TopManager(Company company) {
        this.company = company;
        salary = company.getBaseSalary();

    }

    @Override
    public double getMonthSalary() {
        if (company.getIncome() > 10_000_000.0) {
            double bonusSalaryTopManager = 2.5;
            return salary * bonusSalaryTopManager;
        } else {
            return salary;
        }
    }

    @Override
    public String toString() {
        return "Топ Менеджер: " + numberFormat.format((int) getMonthSalary()) + " руб.";
    }
}