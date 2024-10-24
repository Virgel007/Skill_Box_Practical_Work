package practice.hospital;

import java.text.DecimalFormat;

public class Hospital {

    private final static DecimalFormat FORMAT_1 = new DecimalFormat("#0.0");
    private final static DecimalFormat FORMAT_2 = new DecimalFormat("#0.00");
    private static int healthyCount;


    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientsTemperature = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
         patientsTemperature[i] = getRandomPatientsTemp();
        }
        return patientsTemperature;
    }

    public static float getRandomPatientsTemp() {
        float maxTemp = 40.0f;
        float minTemp = 32.0f;
        return minTemp + (float) (Math.random() * (maxTemp - minTemp));
    }

    public static String getAverageTemperature(float[] temperatureData) {
        float sumTemp = 0f;
        for (float temperatureDatum : temperatureData) {
            sumTemp += temperatureDatum;
        }
        sumTemp /= temperatureData.length;
        return FORMAT_2.format(sumTemp);
    }

    public static String getReport(float[] temperatureData) {
        StringBuilder sb = new StringBuilder();
        for (float temperatureDatum : temperatureData) {
            sb.append(" ").append(FORMAT_1.format(temperatureDatum));
            if (temperatureDatum >= 36.2f && temperatureDatum <= 36.9f) {
                healthyCount++;
            }
        }
        return "Температуры пациентов: " + sb.toString().trim() +
                "\nСредняя температура: " + getAverageTemperature(temperatureData)
                + "\nКоличество здоровых: " + healthyCount;
    }
}