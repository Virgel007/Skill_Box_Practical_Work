public class SwimmingPool {
    public static void main(String[] args) {
        int volume = 1200; //litres
        int fillingSpeed = 30; //30 litres per minute
        int devastationSpeed = 10; //10 litres per minute
        int time = 0; // minute
        int fillingVolume = 0;
        while (fillingVolume < volume) {
            time = time + 1;
            int poolFilling = fillingSpeed - devastationSpeed;
            fillingVolume = fillingVolume + poolFilling;
            System.out.println(time + " время мин. - " + fillingVolume + " литров. заполнения");
        }
        System.out.println("It will fill up in minutes " + time);
    }
}