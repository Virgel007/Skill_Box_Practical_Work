package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Bank implements Runnable {
    private String fromAccountNum;
    private String toAccountNum;
    private long amount;
    private final HashMap<String, Account> accounts;

    public Bank(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }
    public Bank(String fromAccountNum, String toAccountNum, long amount, HashMap<String, Account> accounts) {
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
        this.amount = amount;
        this.accounts = accounts;
    }

    public boolean isFraud() throws InterruptedException {
        Random random = new Random();
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    @Override
    public void run() {
        try {
            transfer(fromAccountNum, toAccountNum, amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        checkingTransfer(fromAccountNum, toAccountNum, amount);
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        boolean wrongName = fromAccount.equals(toAccount);
        if (!wrongName
                && !fromAccount.isAccBlock()
                && fromAccount.getMoney() >= amount) {
            synchronized (fromAccount) {
                long decreaseAmount = fromAccount.getMoney() - amount;
                new Account(decreaseAmount, fromAccount.getAccNumber());
            }
            synchronized (toAccount) {
                long increaseAmount = toAccount.getMoney() + amount;
                new Account(increaseAmount, toAccount.getAccNumber());
            }
            System.out.println("Перевод денек: " + "откуда - " + fromAccountNum + " куда - " + toAccountNum + " сумма: " + amount);
        }
    }

    public void checkingTransfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        boolean wrongName = fromAccountNum.equals(toAccountNum);
        synchronized (fromAccount) {
            if (fromAccount.isAccBlock()) {
                System.out.print("");
                System.out.println("Ошибка! перевода: Аккаунт " + fromAccountNum + " Заблокирован, службой безопасности.");
                return;
            }
            if (wrongName) {
                System.out.print("");
                System.out.println("Ошибка! перевода: откуда - " + fromAccountNum + " куда - " + toAccountNum + " сумма: " + amount);
                return;
            }
            if (fromAccount.getMoney() <= amount) {
                System.out.print("");
                System.out.println("На счете: " + fromAccount.getAccNumber() + " Не достаточно средств");
                return;
            }
            securityCheck(fromAccountNum, amount);
        }
    }

    public void securityCheck(String fromAccountNum, long amount) throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        synchronized (fromAccount) {
            if (amount > 50_000) {
                System.out.println("Перевод отправлен в службу безопасности");
                boolean accBlock = isFraud();
                if (accBlock) {
                    accounts.put(fromAccountNum, new Account(fromAccount.getMoney(),
                            fromAccount.getAccNumber(), true));
                    System.out.println("Ошибка! перевода: Аккаунт " + fromAccountNum + " Заблокирован, службой безопасности.");
                }
            }
        }
    }

    public long getBalance(String accNumber) {
        long balance = 0;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            if (entry.getValue().getAccNumber().equals(accNumber) ||
                    entry.getKey().equals(accNumber)) {
                balance = entry.getValue().getMoney();
            }
        }
        return balance;
    }

    public long getSumAllAccounts() {
        long sumAllAccounts = 0;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            sumAllAccounts = sumAllAccounts + entry.getValue().getMoney();
        }
        return sumAllAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts);
    }
}
