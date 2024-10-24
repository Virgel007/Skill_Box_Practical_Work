package practice.reverseArray;

public class ReverseArray {

    public static String[] reverse(String[] strings) {
//        Collections.reverse(Arrays.asList(strings));
        String[] mass = new String[strings.length];
        for (int j = 0; j < mass.length; j++) {
            mass[j] = strings[mass.length - 1 - j];

        }
        for (int j = 0; j < strings.length; j++) {
            strings[j] = mass[j];
        }
        return strings;
    }
}