package practice.string;

public class SequentialWordsNumbers {

    public static String sequentialWordsNumbers(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;
        StringBuilder word = new StringBuilder();
        String newText = text.trim() + " ";
        if (!text.isEmpty()) {
            for (int i = 0; i < newText.length(); i++) {
                if (newText.length() <= 2 && !Character.isLetter(newText.charAt(i))) {
                    word = new StringBuilder();
                }
                if (newText.charAt(i) != ' ' && newText.length() > 2) {
                    word.append(newText.charAt(i));
                } else {
                    num++;
                    stringBuilder.append(" (").append(num).append(") ").append(word);
                    word = new StringBuilder();
                }
            }
        }
        return stringBuilder.toString().trim();
    }
}