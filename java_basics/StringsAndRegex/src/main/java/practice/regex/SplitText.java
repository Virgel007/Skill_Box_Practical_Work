package practice.regex;
public class SplitText {
  public static void main(String[] args) {
  }
  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод
    String[] words = text.split("[^a-zA-z]+");
    StringBuilder stringBuilder = new StringBuilder();
      for (String word : words) {
          stringBuilder.append(word).append("\n");
      }
    return stringBuilder.toString().strip();
  }
}