public class Arithmetic {
    private final int number1;
    private final int number2;
    public Arithmetic(int a, int b) {
        number1 = a;
        number2 = b;
    }
    public void printNumber() {
        System.out.println("Sum of numbers: " + sum());
        System.out.println();
        System.out.println("Products of numbers: " + product());
        System.out.println();
        System.out.println("The maximum of two numbers: " + max());
        System.out.println();
        System.out.println("The minimum of two numbers: " + min());
    }
    public int sum() {
        return number1 + number2;
    }
    public int product() {
        return number1 * number2;
    }
    public int max() {
        return Math.max(number1, number2);
    }
    public int min() {
        return Math.min(number1, number2);
    }
}