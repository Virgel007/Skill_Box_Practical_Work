public class Processor {
    private final String processor;
    private final double frequency;
    private final int numberCores;
    private final String manufacturer;
    private final double weight;

    @Override
    public String toString() {
        return "Процессор: " + processor + "\n" +
                "Частота процессора: " + frequency + " Гц." + "\n" +
                "Кол-во Ядер: " + numberCores + "\n" +
                "Производитель: " + manufacturer + "\n" +
                "Вес: " + weight + " гр." + "\n";
    }

    public Processor(String processor, double frequency, int numberCores, String manufacturer, double weight) {
        this.processor = processor;
        this.frequency = frequency;
        this.numberCores = numberCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public String getProcessor() {
        return processor;
    }

    public double getFrequency() {
        return frequency;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getNumberCores() {
        return numberCores;
    }

    public double getWeight() {
        return weight;
    }
}