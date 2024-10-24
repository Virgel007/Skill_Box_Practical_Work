package org.example;

import java.io.File;
import java.util.Objects;

public class App {
    private static final String FILE_PATH = "C:\\work\\GIT_LAB\\java_basics\\Multithreading\\ImageResizer\\Data";
    private static final String SRC_FOLDER = FILE_PATH + "/srcFolder";
    private static final String DST_FOLDER = FILE_PATH + "/dstFolder";
    private static final File SRC_DIR = new File(SRC_FOLDER);
    private static final File[] IMAGES_LIST = Objects.requireNonNull(SRC_DIR.listFiles());
    private static final Integer COUNT_IMAGES_LIST = Objects.requireNonNull(SRC_DIR.listFiles()).length;
    private static final int PROCESSOR_MAX_THREAD = 16;
    private static final Integer FILE_PER_THREAD = filePerThread();
    private static final long START = System.currentTimeMillis();

    public static void main(String[] args) {
        System.out.println("Кол-во файлов на 1 поток: " + FILE_PER_THREAD + " - Кол-во потоков у процессора: " + PROCESSOR_MAX_THREAD);

        for (int i = 0; i < COUNT_IMAGES_LIST; i = i + FILE_PER_THREAD) {
            threads(i);
        }
    }

    public static int filePerThread() {
        return Objects.requireNonNull(SRC_DIR.listFiles()).length / PROCESSOR_MAX_THREAD;
    }

    public static void threads(int srcPos) {
            File[] files = new File[FILE_PER_THREAD];
            System.arraycopy(IMAGES_LIST, srcPos, files, 0, FILE_PER_THREAD);
            ImageResizer resizer = new ImageResizer(DST_FOLDER, files, START);
            new Thread(resizer).start();
            System.out.println("Start Thread: " + Thread.currentThread().getName());
    }
}