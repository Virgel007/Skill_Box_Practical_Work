public class PrimitiveChar {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        char symbol = 'ё';
        char symbol1 = 'Ё';
        int code = symbol;
        int code1 = symbol1;
        for (int i = 1040; i < 1104; i++) {
            char c = (char) i;
            System.out.println(i + " - " + c);
        }
        System.out.println(code + " - " + symbol + "\n" +
                code1 + " - " + symbol1);
    }
}
