
public class AbstractClasses {

    public static void main(String[] args) {
        Company company1 = new Company("Фирма1");

        int operatorCompany1 = 180; int managerCompany1 = 80; int topManagerCompany1 = 10;

        System.out.println("Наймите в компанию: " + operatorCompany1 + " операторов");

        for (int i = 0; i < operatorCompany1; i++) {
            Operator operator = new Operator(company1);
            company1.hire(operator);
        }

        System.out.println("Наймите в компанию: " + managerCompany1 + " менеджеров");

        for (int i = 0; i < managerCompany1; i++) {
            Manager manager = new Manager(company1);
            company1.hire(manager);
        }

        System.out.println("Наймите в компанию: " + topManagerCompany1 + " топ менеджеров");

        for (int i = 0; i < topManagerCompany1; i++) {
            TopManager topManager = new TopManager(company1);
            company1.hire(topManager);
        }

        System.out.println();
        System.out.println(company1 + "\n");
        int topSalaryStaffCount = 15; int lowerSalaryStaffCount = 30;

        System.out.println("Распечатайте список из " + topSalaryStaffCount + " самых высоких зарплат в компании.");
        for (Employee employee2 : company1.getTopSalaryStaff(topSalaryStaffCount)) {
            System.out.println(employee2);
        }

        System.out.println("\n" + "Распечатайте список из " + lowerSalaryStaffCount + " самых низких зарплат в компании.");
        for (Employee employee2 : company1.getLowestSalaryStaff(lowerSalaryStaffCount)) {
            System.out.println(employee2);
        }

        System.out.println();
        System.out.println("Увольте 50% сотрудников." + "\n");

        int fireSize = company1.getEmployees().size() / 2;
        for (int i = 0; i < fireSize; i++) {
            company1.fire(company1.getEmployees().get(i));
        }

        System.out.println(company1 + "\n");

        System.out.println("Распечатайте список из " + topSalaryStaffCount + " самых высоких зарплат в компании.");
        for (Employee employee2 : company1.getTopSalaryStaff(topSalaryStaffCount)) {
            System.out.println(employee2);
        }
        System.out.println("\n" + "Распечатайте список из " + lowerSalaryStaffCount + " самых низких зарплат в компании.");
        for (Employee employee2 : company1.getLowestSalaryStaff(lowerSalaryStaffCount)) {
            System.out.println(employee2);
        }
        System.out.println();
        System.out.println("////////////////////////////////////////////////////////////////////");

        Company company2 = new Company("Фирма2 нанимает сотрудников Фирма1");
        company2.hireAll(company1.getEmployees());
        System.out.println(company2 + "\n");
        System.out.println("Распечатайте список из 15 самых высоких зарплат в компании.");
        for (Employee employee : company2.getTopSalaryStaff(15)) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("Распечатайте список из 30 самых низких зарплат в компании.");
        for (Employee employee : company2.getLowestSalaryStaff(30)) {
            System.out.println(employee);
        }
    }
}