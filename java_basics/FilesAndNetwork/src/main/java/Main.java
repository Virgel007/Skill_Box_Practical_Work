import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        String filepath = "FilesAndNetwork/";
        String pathMapMoscow = filepath + "data/map.json";
        String pathStationsInfo = filepath + "data/stations.json";

        JsonMoscowMap mapMoscow = new JsonMoscowMap();
        JsonStationsInfo stationsInfo = new JsonStationsInfo();

        JSONObject objMapMoscow = mapMoscow.getMainObject();
        JSONObject objStationsInfo = stationsInfo.getMainObject();

        JsonWriter.writer(objMapMoscow, pathMapMoscow);
        JsonWriter.writer(objStationsInfo, pathStationsInfo);
    }
}
