package practice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccount cardAccount = new CardAccount(100_000);
        cardAccount.put(50_000);
        cardAccount.take(590);
        System.out.println("Остаток на счете: " + cardAccount.getAmount());
        BankAccount deposit = new DepositAccount(100_000, LocalDate.of(2024,1,20));
        deposit.take(20_000);
        System.out.println("Остаток на счете: " + deposit.getAmount());
    }
}
