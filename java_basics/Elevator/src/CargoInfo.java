public class CargoInfo {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean flip;
    private final String registrationNumber;
    private final boolean fragileCargo;
    private final double cargoLength;
    private final double cargoWidth;
    private final double cargoHeight;

    public CargoInfo setDimensions(Dimensions dimensions) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo setWeight(double weight) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo setDeliveryAddress(String deliveryAddress) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo setFlip(boolean flip) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo setRegistrationNumber(String registrationNumber) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo setFragileCargo(boolean fragileCargo) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo setCargoLength(double cargoLength) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo setCargoWidth(double cargoWidth) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo setCargoHeight(double cargoHeight) {
        return new CargoInfo(dimensions, weight, deliveryAddress, flip, registrationNumber, fragileCargo, cargoLength, cargoWidth, cargoHeight);
    }

    public CargoInfo(Dimensions dimensions, double weight,
                     String deliveryAddress, boolean flip,
                     String registrationNumber, boolean fragileCargo,
                     double cargoLength, double cargoWidth, double cargoHeight) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.flip = flip;
        this.registrationNumber = registrationNumber;
        this.fragileCargo = fragileCargo;
        this.cargoLength = cargoLength;
        this.cargoWidth = cargoWidth;
        this.cargoHeight = cargoHeight;
    }

    public String toString() {
        return "Вес груза: " + weight + " кг." + "\n" +
                "Адрес доставки: " + deliveryAddress + "\n" +
                "Габариты груза: " + "\n" + dimensions + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n" +
                "Хрупкий груз: " + flip + "\n" +
                "Можно ли переворачивать: " + fragileCargo;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getCargoLength() {
        return cargoLength;
    }

    public double getCargoWidth() {
        return cargoWidth;
    }

    public double getCargoHeight() {
        return cargoHeight;
    }

    public double getWeight() {
        return weight;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isFlip() {
        return flip;
    }

    public boolean isFragileCargo() {
        return fragileCargo;
    }
}
