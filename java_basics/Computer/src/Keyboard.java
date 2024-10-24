public class Keyboard {
    private final String keyboard;
    private final KeyboardType type;
    private final KeyboardLighting lighting;
    private final double weight;

    @Override
    public String toString() {
        return "Клавиатура: " + keyboard + "\n" +
                "Тип: " + type + "\n" +
                "Подсветка: " + lighting + "\n" +
                "Вес: " + weight + " гр." + "\n";
    }

    public Keyboard(String keyboard, KeyboardType keyboardType, KeyboardLighting keyboardLighting, double weight) {
        this.keyboard = keyboard;
        this.type = keyboardType;
        this.lighting = keyboardLighting;
        this.weight = weight;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public KeyboardType getType() {
        return type;
    }

    public KeyboardLighting getLighting() {
        return lighting;
    }

    public double getWeight() {
        return weight;
    }
}
