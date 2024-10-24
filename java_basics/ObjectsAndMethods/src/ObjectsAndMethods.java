public class ObjectsAndMethods {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 65, 2, 500);
        basket.add("Eggs", 90, 3, 250);
        basket.add("Apples", 35, 5, 340);
        basket.print("Корзина");
        System.out.println("Общий вес: " + basket.getTotalWeight());
    }
}