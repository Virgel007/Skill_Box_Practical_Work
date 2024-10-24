import java.io.PrintWriter;

public class Loader {

    public static void main(String[] args) throws InterruptedException {
        threads(1, 1, 11);
        threads(2, 11, 21);
        threads(3, 21, 31);
        threads(4, 31, 41);
        threads(5, 41, 51);
        threads(6, 51, 61);
        threads(7, 61, 71);
        threads(8, 71, 81);
        threads(9, 81, 91);
    }

    public static void createNumber(String nameFile, int regionStart, int regionEnd, int numberStart, int numberEnd) {
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        StringBuilder builder = new StringBuilder();
        for (int regionCode = regionStart; regionCode < regionEnd; regionCode++) {
            for (int number = numberStart; number < numberEnd; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter)
                                    .append("000".substring(String.valueOf(number).length())).append(number)
                                    .append(secondLetter)
                                    .append(thirdLetter)
                                    .append("00".substring(String.valueOf(regionCode).length())).append(regionCode)
                                    .append("\n");

                        }
                    }
                }
            }
        }
        writerFile(nameFile, builder);
    }


    public static void writerFile(String pathFile, StringBuilder builder) {
        String path = "Performance/CarNumberGenerator/";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path + "res/" + pathFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }

    public static void threads(int path, int regionStart, int regionEnd) {
        String pathNumberFail = "numbers" + path + ".txt";
        if (regionStart < 0 && regionEnd < 0) {
            return;
        }

        if (regionStart > 199 && regionEnd > 199) {
            return;
        }

        new Thread(() -> {
            long start = System.currentTimeMillis();
            createNumber(pathNumberFail, regionStart, regionEnd, 1, 1000);
            System.out.println((System.currentTimeMillis() - start) + " ms");
        }).start();
    }
}
