package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.System.out;

public class RedisTest {

    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis

    // Для теста будем считать неактивными пользователей, которые не заходили 2 секунды
    private static final int DELETE_SECONDS_AGO = 2;

    // Допустим пользователи делают 500 запросов к сайту в секунду
    private static final int RPS = 500;

    // И всего на сайт заходило 1000 различных пользователей
    private static final int USERS = 1000;

    // Также мы добавим задержку между посещениями
    private static final int SLEEP = 1; // 1 миллисекунда

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    private static void log(int UsersOnline) {
        String log = String.format("[%s] — На главной странице показываем пользователя: %d", DF.format(new Date()), UsersOnline);
        out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();

        for (int i = 0; i < 1000; i++) {
            for (int user = 1; user <= 20; ++user) {
                for (int request = 0; request <= RPS; request++) {
                    int user_id = new Random().nextInt(USERS);
                    redis.logPageVisit(user_id);
                    Thread.sleep(SLEEP);
                }
                redis.deleteOldEntries(DELETE_SECONDS_AGO);
            int usersOnline = redis.calculateUsersNumber();
                log(user);
            }
            redis.shutdown();
        }
    }
}