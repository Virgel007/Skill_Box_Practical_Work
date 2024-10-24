public class RamMemory {
    private final String memory;
    private final RamMemoryType type;
    private final double volume;
    private final double weight;

    public RamMemory(String memory, RamMemoryType ramMemoryType, double volume, double weight) {
        this.memory = memory;
        this.type = ramMemoryType;
        this.volume = volume;
        this.weight = weight;
    }

    public RamMemoryType getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public String getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "ОЗУ: " + memory + "\n" +
                "Тип ОЗУ: " + type + "\n" +
                "Объем памяти: " + volume + " Гб." + "\n" +
                "Вес: " + weight + " гр." + "\n";
    }
}