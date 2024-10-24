import java.util.Scanner;

public class ElevatorAndCargo {
    public static void main(String[] args) {
        quest1();
//        quest2();
    }

    public static void quest1() {
        System.out.println();
        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }
    }

    public static void quest2() {
        Dimensions dimensions = new Dimensions(150, 100, 100);
        dimensions.setCargoLength(1000);
        dimensions.setCargoWidth(1000);
        dimensions.setCargoHeight(1000);
        CargoInfo cargoInfo = new CargoInfo(dimensions, 250, "Войнов", false, "RU47587S", true,1,1,1);
        System.out.println(cargoInfo);
        System.out.println("Объем груза: " + dimensions.calculationsVolume() + " м3.");
    }
}