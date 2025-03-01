import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class ParseCsvFile {
    private List<String> csvLines;
    private List<StationDate> stationsDates;

    public ParseCsvFile() {
        parse();
        listFormatted();
    }

    private void parse() {
        stationsDates = new ArrayList<>();
        List<String> lines = getCsvInLines();
        for (String line : lines) {
            String[] tokens = line.split(",");
            if (tokens.length != 2) {
                System.out.println("Wrong line = " + line);
            }
            stationsDates.add(new StationDate(tokens[0], tokens[1]));
        }
    }

    private List<String> getCsvInLines() {
        List<String> lines;
        csvLines = new ArrayList<>();

        FilesSearch filesSearch = new FilesSearch();
        String[] paths = filesSearch.getCSVFilesAbsolutePath().split("\n");
        for (String path : paths) {
            try {
                lines = readAllLines(Path.of(path));
                lines.remove(0);
                csvLines.addAll(lines);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return csvLines;
    }

    private void listFormatted() {
        for (int i = 0; i < stationsDates.size(); i ++) {
            String name = stationsDates.get(i).getName();
            String date = stationsDates.get(i).getDate();
            for (int j = 0; j <stationsDates.size(); j++) {
                String anotherName = stationsDates.get(j).getName();
                String anotherdate = stationsDates.get(j).getDate();
                if (name.equals(anotherName) && date.equals(anotherdate)) {
                    stationsDates.remove(j);
                }
            }
        }
    }


    public List<StationDate> getStationsDates() {
        return stationsDates;
    }
}
