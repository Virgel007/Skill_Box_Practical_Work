public class Booleans {
    public static void main(String[] args) {
        int milkAmount = 200; // ml default 200
        int powderAmount = 5; // g default 5
        int eggsCount = 3; // items default 3
        int sugarAmount = 5; // g default 5
        int oilAmount = 30; // ml default 30
        int appleCount = 8; // items default 8

            if (appleCount >= 5) {
                System.out.println("Apple juice");
            } else {
                System.out.println("There are not enough ingredients for Apple juice");
            }

        boolean totalIngredientsPancakes = powderAmount >= 400 && sugarAmount >= 10 && milkAmount >= 1000 && oilAmount >= 30;
        String messagePancakes = totalIngredientsPancakes ? "Pancakes" : "There are not enough ingredients for Pancakes";
        System.out.println(messagePancakes);

        boolean totalIngredientsOmelette = milkAmount >= 300 && powderAmount >= 5 && eggsCount >= 5;
        String messageOmelette = totalIngredientsOmelette ? "Omelette" : "There are not enough ingredients for Omelette";
        System.out.println(messageOmelette);

        if (appleCount >= 3 && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4) {
            // apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
            System.out.println("Apple pie");
        } else {
            System.out.println("There are not enough ingredients for Apple pie");
        }
    }
}
