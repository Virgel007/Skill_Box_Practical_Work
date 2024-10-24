package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    public DepositAccount() {}
    public DepositAccount(double amount, LocalDate lastIncome) {
        super(amount);
        this.lastIncome = lastIncome;
    }

    LocalDate lastIncome = LocalDate.now();
    @Override
    public void take(double amountToTake) {
        LocalDate nowTime = LocalDate.now();
        if (nowTime.isAfter(lastIncome.plusMonths(1))) {
            super.take(amountToTake);
        }
    }
}