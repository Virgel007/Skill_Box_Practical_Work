package practice;

import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        HashSet<String> strings1 = new HashSet<>(CoolNumbers.generateCoolNumbers());
        TreeSet<String> strings2 = new TreeSet<>(CoolNumbers.generateCoolNumbers());
        String number = "В555УН55";
        CoolNumbers.bruteForceSearchInList(CoolNumbers.generateCoolNumbers(), number);
        CoolNumbers.binarySearchInList(CoolNumbers.generateCoolNumbers(), number);
        CoolNumbers.searchInHashSet(strings1, number);
        CoolNumbers.searchInTreeSet(strings2, number);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println(elapsed + " мс.");
        System.out.println(CoolNumbers.generateCoolNumbers().get(5));
    }
}