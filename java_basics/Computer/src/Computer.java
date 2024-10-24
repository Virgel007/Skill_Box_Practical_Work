public class Computer {
    private final String vendor;
    private final String name;
    private Processor processor;
    private RamMemory ramMemory;
    private StorageInformation storageInformation;
    private MonitorScreen monitorScreen;
    private Keyboard keyboard;

    public Computer(Processor processor, RamMemory ramMemory, StorageInformation storageInformation,
                    MonitorScreen monitorScreen, Keyboard keyboard, String vendor, String name) {
        this.processor = processor;
        this.ramMemory = ramMemory;
        this.storageInformation = storageInformation;
        this.monitorScreen = monitorScreen;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.name = name;
    }

    public double calculateComputerWeight() {
        return keyboard.getWeight() +
                monitorScreen.getWeight() +
                processor.getWeight() +
                ramMemory.getWeight() +
                storageInformation.getWeight();
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RamMemory getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(RamMemory ramMemory) {
        this.ramMemory = ramMemory;
    }

    public StorageInformation getStorageInformation() {
        return storageInformation;
    }

    public void setStorageInformation(StorageInformation storageInformation) {
        this.storageInformation = storageInformation;
    }

    public MonitorScreen getMonitorScreen() {
        return monitorScreen;
    }

    public void setMonitorScreen(MonitorScreen monitorScreen) {
        this.monitorScreen = monitorScreen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return processor + "\n" +
                ramMemory + "\n" +
                storageInformation + "\n" +
                monitorScreen + "\n" +
                keyboard + "\n" +
                "Вес компьютера: " + calculateComputerWeight() + " гр." + "\n";
    }
}