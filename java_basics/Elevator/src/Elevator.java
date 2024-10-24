public class Elevator {
    private int currentFloor = 1;

    private int minFloor; // -3

    private int maxFloor; // 26

    public Elevator(int minFloor, int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public void moveUp() {
//TODO       currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
        if (currentFloor < maxFloor) {
            currentFloor = currentFloor + 1;
        }
    }

    public void moveDown() {
//TODO        currentFloor = currentFloor > minFloor ? currentFloor -1 : currentFloor;
        if (currentFloor > minFloor) {
            currentFloor = currentFloor - 1;
        }
    }

    public void move(int floor) {
        if (floor < minFloor || floor > maxFloor || floor == 0) {
            System.out.println("Такого этажа нет!");
        } else if (floor < currentFloor) {
            do {
                moveDown();
                if (currentFloor != 0) {
                    System.out.println("Этаж №" + currentFloor);
                }
            } while (floor != currentFloor);
        } else if (floor > currentFloor) {
            do {
                moveUp();
                if (currentFloor != 0) {
                    System.out.println("Этаж №" + currentFloor);
                }
            } while (floor != currentFloor);
        } else {
            System.out.println("Текущий этаж: " + currentFloor);
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}