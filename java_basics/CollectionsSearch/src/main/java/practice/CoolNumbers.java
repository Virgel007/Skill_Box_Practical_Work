package practice;

import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        long start = System.nanoTime();
        HashSet<String> hashSet = new HashSet<>();
        Random random = new Random();
        String char1 = "АВЕКМНОРСТУХ";
        String char2 = "123456789";
        String char3 = "0123456789";
        String char4 = " 1";
        String result = "";
        do {
            char c1 = char1.charAt(random.nextInt(char1.length()));
            char c2 = char2.charAt(random.nextInt(char2.length()));
            char c3 = char2.charAt(random.nextInt(char2.length()));
            char c4 = char2.charAt(random.nextInt(char2.length()));
            char c5 = char1.charAt(random.nextInt(char1.length()));
            char c6 = char1.charAt(random.nextInt(char1.length()));
            char c7 = char4.charAt(random.nextInt(char4.length()));
            char c8 = char3.charAt(random.nextInt(char3.length()));
            char c9 = char2.charAt(random.nextInt(char2.length()));
            result = ((c1 + "" + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9).replaceAll(" ", ""));
            hashSet.add(result);
        } while (hashSet.size() < 2_000_000);
        List<String> list = new ArrayList<>(hashSet);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println(elapsed + " ns.");
        return list;
    }


    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long start = System.nanoTime();
        for (String string : list) {
            if (number.equals(string)) {
                System.out.println("Номер найден");
                return true;
            }
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println(elapsed + " ns.");
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long start = System.nanoTime();
        if (sortedList.contains(number)) {
            System.out.println("Номер найден");
            return true;
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println(elapsed + " ns.");
        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long start = System.nanoTime();
        if (hashSet.contains(number)) {
            System.out.println("Номер найден");
            return true;
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println(elapsed + " ns.");
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long start = System.nanoTime();
        if (treeSet.contains(number)) {
            System.out.println("Номер найден");
            return true;
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println(elapsed + " ns.");
        return false;
    }
}