package org.example;

import java.util.*;


public class App {
    private static String FROM_ACCOUNT_NUM;
    private static String TO_ACCOUNT_NUM;
    private static long AMOUNT;
    private static final HashMap<String, Account> ACCOUNTS = new HashMap<>();
    private static final Bank BANK = new Bank(ACCOUNTS);

    public static void main(String[] args) throws InterruptedException {
        createAccountBase();
        Thread.sleep(1_000);
        System.out.println("Сумма всех активов в банке: " + BANK.getSumAllAccounts() + " руб.");

        for (int i = 0; i < 8; i++) {
            long timeStart = System.currentTimeMillis();
            new Thread(() -> {
                for (int j = 0; j < 10_000; j++) {
                    FROM_ACCOUNT_NUM = getRandomAccount();
                    TO_ACCOUNT_NUM = getRandomAccount();
                    AMOUNT = getRandomTransactionAmount();
                    System.out.println("Баланс отправителя до перевода: " + FROM_ACCOUNT_NUM + " - " + BANK.getBalance(FROM_ACCOUNT_NUM) + " руб.");
                    System.out.println("Баланс получателя до перевода: " + TO_ACCOUNT_NUM + " - " + BANK.getBalance(TO_ACCOUNT_NUM) + " руб.");
                    BANK.setFromAccountNum(FROM_ACCOUNT_NUM);
                    BANK.setToAccountNum(TO_ACCOUNT_NUM);
                    BANK.setAmount(AMOUNT);
                    BANK.run();
                    System.out.println("Баланс отправителя после перевода: " + FROM_ACCOUNT_NUM + " - " + BANK.getBalance(FROM_ACCOUNT_NUM) + " руб.");
                    System.out.println("Баланс получателя после перевода " + TO_ACCOUNT_NUM + " - " + BANK.getBalance(TO_ACCOUNT_NUM) + " руб.");
                }
                System.out.println(System.currentTimeMillis() - timeStart);
            }).start();
        }
    }


    public static void createAccountBase() {
        Random random = new Random();
        String surnameInitials = "ФКИСГНВЕА";
        String zeroNumber = "0000";
        for (int i = 1; i < 11; ++i) {
            char getSurnameInitialsRandom = surnameInitials.charAt(random.nextInt(surnameInitials.length()));
            String accNumber = zeroNumber.substring(String.valueOf(i).length()) + (i);
            String accountName = generationAccName() + ". " + getSurnameInitialsRandom + ". " + accNumber;
            ACCOUNTS.put(accountName, new Account(generationAccBalance(), accNumber, false));
        }
    }

    public static String generationAccName() {
        String[] accNames = {"Аркадий", "Артем", "Ирина", "Алексей", "Александр", "Света", "Ольга", "Сергей", "Екатерина", "Иван", "Виктор"};
        int randomValue = (int) (Math.random() * 11);
        return accNames[randomValue];
    }

    public static int generationAccBalance() {
        return (int) (Math.random() * 1_000_000_000);
    }

    public static String getRandomAccount() {
        List<String> stringsList = ACCOUNTS.keySet().stream().toList();
        int randomValue = (int) (Math.random() * stringsList.size());
        return stringsList.get(randomValue);
    }

    public static int getRandomTransactionAmount() {
        return (int) (Math.random() * 55_000);
    }
}