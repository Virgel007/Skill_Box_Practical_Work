public class MonitorScreen {
    private final String monitor;
    private final double diagonal;
    private final MonitorScreenType type;
    private final double weight;

    @Override
    public String toString() {
        return "Монитор: " + monitor + "\n" +
                "Диагональ: " + diagonal + " Дюймов." + "\n" +
                "Тип экрана: " + type + "\n" +
                "Вес: " + weight + " гр." + "\n";
    }

    public MonitorScreen(String monitor, double diagonal, MonitorScreenType monitorScreenType, double weight) {
        this.monitor = monitor;
        this.diagonal = diagonal;
        this.type = monitorScreenType;
        this.weight = weight;
    }

    public String getMonitor() {
        return monitor;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public MonitorScreenType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }
}