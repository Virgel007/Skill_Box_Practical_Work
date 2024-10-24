package org.example;

import java.util.*;


public class AppNoSQL {
    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis

    // docker exec -it skill-redis redis-cli   // redis  в cmd
    private static final HashMap<Date, Users> USERS_MAP = new HashMap<>();

    public static void main(String[] args) {
        // Условия задания

        // Напишите программу, которая будет эмулировать работу такого сайта,
        // !!! хранить очередь в Redis и выводить лог операций в консоль !!!
        //
        // На сайте знакомств зарегистрировалось 20 пользователей.
        // Показывайте их по очереди на главной странице сайта.
        //
        // По умолчанию порядок очереди зависит от времени регистрации на сайте.
        // После каждого показа пользователь отправляется в конец очереди.
        // Пользователь может оплатить услугу по перемещению в начало очереди.
        baseUser();
        TreeMap<Date, Users> sortUser = new TreeMap<>(USERS_MAP);
        for (int i = 0; i < 500; i++) {
            Date timeReg = getUserRandomDate();
            if (!sortUser.get(timeReg).isServiceFrontQueue()) {
                System.out.println("— На главной странице показываем пользователя: " + sortUser.get(timeReg).toString());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            usersBayService();
        }
    }

    public static void usersBayService() {
        TreeMap<Date, Users> sortUser = new TreeMap<>(USERS_MAP);
        sortUser.forEach((date, user) -> {
            Date timeReg = getUserRandomDate();
            USERS_MAP.get(timeReg).setServiceFrontQueue(true);
            if (user.isServiceFrontQueue()) {
                System.out.println(" — > Пользователь " + user + " оплатил платную услугу!!!");
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            USERS_MAP.get(timeReg).setServiceFrontQueue(false);
        });
    }

    public static Date getUserRandomDate() {
        List<Date> dateList = new ArrayList<>();
        USERS_MAP.forEach((date, users) -> dateList.add(date));
        int randomValue = (int) (Math.random() * dateList.size());
        return dateList.get(randomValue);
    }

    public static void baseUser() {
        for (int i = 0; i < 20; i++) {
            Date regTime = new Date(randomTime());
            USERS_MAP.put(regTime, new Users(generationUserName(), regTime, false));
        }
    }

    public static long randomTime() {
        return System.currentTimeMillis() - (long) (Math.random() * 1000000000L);
    }

    public static String generationUserName() {
        String[] accNames = {
                "USER Аркадий.П", "USER Артем.П", "USER Ирина.П", "USER Алексей.П", "USER Александр.П", "USER Света.П", "USER Ольга.П", "USER Сергей.П", "USER Екатерина.П", "USER Иван.П", "USER Виктор.П",
                "USER Аркадий.К", "USER Артем.К", "USER Ирина.К", "USER Алексей.К", "USER Александр.К", "USER Света.К", "USER Ольга.К", "USER Сергей.К", "USER Екатерина.К", "USER Иван.К", "USER Виктор.К",
                "USER Аркадий.И", "USER Артем.И", "USER Ирина.И", "USER Алексей.И", "USER Александр.И", "USER Света.И", "USER Ольга.И", "USER Сергей.И", "USER Екатерина.И", "USER Иван.И", "USER Виктор.И",
                "USER Аркадий.Ж", "USER Артем.Ж", "USER Ирина.Ж", "USER Алексей.Ж", "USER Александр.Ж", "USER Света.Ж", "USER Ольга.Ж", "USER Сергей.Ж", "USER Екатерина.Ж", "USER Иван.Ж", "USER Виктор.Ж",
                "USER Аркадий.Д", "USER Артем.Д", "USER Ирина.Д", "USER Алексей.Д", "USER Александр.Д", "USER Света.Д", "USER Ольга.Д", "USER Сергей.Д", "USER Екатерина.Д", "USER Иван.Д", "USER Виктор.Д"
        };
        int randomValue = (int) (Math.random() * 55);
        return accNames[randomValue];
    }
}