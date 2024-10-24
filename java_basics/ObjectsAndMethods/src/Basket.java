public class Basket {
    private String items = "";
    /**
     * Внесите следующие изменения в класс Basket:
     *
     * Добавьте две статические переменные для хранения общей стоимости и общего количества всех товаров во всех корзинах.
     * Реализуйте статические методы, которые будут увеличивать значения этих переменных при добавлении в корзину новых товаров.
     * Реализуйте статический метод расчёта средней цены товара во всех корзинах.
     * Он должен рассчитывать и возвращать отношение общей стоимости всех корзин к общему количеству всех товаров.
     * Реализуйте статический метод расчёта средней стоимости корзины (отношение общей стоимости всех корзин к количеству корзин).
     * Названия и типы переменных, а также названия и методов придумайте самостоятельно.
     */

    private static int count = 0;
    private static int totalPrice = 0;
    private static int limit;
    private static double totalWeight = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        limit = 1000000;
    }

    public Basket(int limit) {
        this();
        Basket.limit = limit;
    }

    public Basket(String items, int totalPrice, double totalWeight) {
        this();
        this.items = this.items + items;
        Basket.totalPrice = totalPrice;
        Basket.totalWeight = totalWeight;
    }

    public void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 0);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = contains(name);
        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occurred :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт." + " Цена: " + price + " Вес: " + weight;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Сумма: " + totalPrice);
            System.out.println("Общий вес: " + totalWeight);
        }
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}
