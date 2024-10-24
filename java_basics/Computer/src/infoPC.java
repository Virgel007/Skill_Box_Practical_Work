public class infoPC {
    public static void main(String[] args) {
        Processor pc1Processor = new Processor
                ("Ryzen 7 5800 OEM", 4, 8, "AMD", 50);
        RamMemory pc1Rammemory = new RamMemory
                ("Samsung", RamMemoryType.DDR4, 16, 100);
        StorageInformation pc1Storageinformation = new StorageInformation
                ("Samsung 980 PRO", StorageInformationType.M2, 1000, 250);
        MonitorScreen pc1MonitorScreen = new MonitorScreen
                ("ARDOR GAMING PORTAL AF24H1", 23.8, MonitorScreenType.IPS, 3000);
        Keyboard pc1Keyboard = new Keyboard
                ("ARDOR GAMING x DURGOD Space Fusion", KeyboardType.MECHANICAL, KeyboardLighting.YES, 1000);
        Computer computer1 = new Computer(pc1Processor, pc1Rammemory, pc1Storageinformation, pc1MonitorScreen, pc1Keyboard, "", "");
        System.out.println("Компьютер №1:" + "\n" + computer1);

        Processor pc2Processor = new Processor
                ("Intel Core i5-12400F OEM", 4, 8, "Intel", 30);
        RamMemory pc2Rammemory = new RamMemory
                ("Samsung", RamMemoryType.DDR4, 16, 100);
        StorageInformation pc2Storageinformation = new StorageInformation
                ("Samsung 980 PRO", StorageInformationType.M2, 1000, 250);
        MonitorScreen pc2MonitorScreen = new MonitorScreen
                ("ARDOR GAMING PORTAL AF24H1", 23.8, MonitorScreenType.IPS, 3000);
        Keyboard pc2Keyboard = new Keyboard
                ("ARDOR GAMING x DURGOD Space Fusion", KeyboardType.MECHANICAL, KeyboardLighting.YES, 1000);
        Computer computer2 = new Computer(pc2Processor, pc2Rammemory, pc2Storageinformation, pc2MonitorScreen, pc2Keyboard, "", "");
        System.out.println("Компьютер №2:" + "\n" + computer2);
//  TODO change processor      computer2.setProcessor(pc1Processor);
    }
}