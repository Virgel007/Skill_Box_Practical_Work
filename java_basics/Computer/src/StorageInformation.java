public class StorageInformation {
    private final String storageInfo;
    private final StorageInformationType type;
    private final double volume;
    private final double weight;

    @Override
    public String toString() {
        return "Накопитель: " + storageInfo + "\n" +
                "Тип накопителя: " + type + "\n" +
                "Объем памяти: " + volume + " Гб." + "\n" +
                "Вес: " + weight + " гр." + "\n";
    }

    public StorageInformation(String storageInfo, StorageInformationType storageInformationType, double volume, double weight) {
        this.storageInfo = storageInfo;
        this.type = storageInformationType;
        this.volume = volume;
        this.weight = weight;
    }

    public String getStorageInfo() {
        return storageInfo;
    }

    public StorageInformationType getStorageInformationType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}