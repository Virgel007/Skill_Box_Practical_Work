package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParserForkJoin {
    private static long START = System.currentTimeMillis();
    private static final String LINKS;
    static List<Links> linksList = new ArrayList<>();

    static {
        Links task = new Links("https://lenta.ru/", START);
        task.isDone();
        LINKS = new ForkJoinPool().invoke(task);
        linksList.add(task);
    }

    public static void main(String[] args) {
        System.out.println(LINKS);
        String pathFile = "C:\\work\\GIT_LAB\\java_basics\\Multithreading\\ForkJoinPool\\";
        {
            try {
                FileWriter writer = new FileWriter(pathFile + "src/main/resources/ParserFile/Links.txt");
                writer.write(LINKS);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}