package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        int boxes;
        int container = 0;
        int cargo = 0;
        int boxInCont = 27;
        int contInCargo = 12;
        Scanner scanner = new Scanner(System.in);
        boxes = scanner.nextInt();
        if (boxes >= 0) {
            for (int i = 0; i <= (boxes - 1); i++) {
                if (i % (contInCargo * boxInCont) == 0) {
                    cargo++;
                    System.out.println("Грузовик: " + cargo);
                }
                if (i % boxInCont == 0) {
                    container++;
                    System.out.println("\t" + "Контейнер: " + container);
                }
                System.out.println("\t" + "\t" + "Ящик: " + (i + 1));
            }
            System.out.println("Необходимо:");
            System.out.println("грузовиков - " + cargo + " шт.");
            System.out.println("контейнеров - " + container + " шт.");
        }
    }
}