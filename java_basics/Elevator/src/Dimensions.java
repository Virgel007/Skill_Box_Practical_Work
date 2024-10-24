public class Dimensions {
    private final double cargoLength;
    private final double cargoWidth;
    private final double cargoHeight;

    public Dimensions(double cargoLength, double cargoWidth, double cargoHeight) {
        this.cargoLength = cargoLength;
        this.cargoWidth = cargoWidth;
        this.cargoHeight = cargoHeight;
    }

    public Dimensions setCargoLength(double cargoLength) {
        return new Dimensions(cargoLength, cargoWidth, cargoHeight);
    }

    public Dimensions setCargoWidth(double cargoWidth) {
        return new Dimensions(cargoLength, cargoWidth, cargoHeight);
    }

    public Dimensions setCargoHeight(double cargoHeight) {
        return new Dimensions(cargoLength, cargoWidth, cargoHeight);
    }

    public double getCargoWidth() {
        return cargoWidth;
    }

    public double getCargoHeight() {
        return cargoHeight;
    }

    public double getCargoLength() {
        return cargoLength;
    }

    public double calculationsVolume() {
        return ((cargoWidth * cargoLength * cargoHeight) / 1000000);
    }

    public String toString() {
        return " Длина: " + cargoLength + " см. " + "\n" +
                " Ширина: " + cargoWidth + " см. " + "\n" +
                " Высота: " + cargoHeight + " см.";
    }
}