import java.util.*;
class UndergroundSystem {
    HashMap<Integer, String> checkInStation;
    HashMap<Integer, Integer> checkInTime;
    HashMap<String, double[]> travelData;
    public UndergroundSystem() {
        checkInStation = new HashMap<>();
        checkInTime = new HashMap<>();
        travelData = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkInStation.put(id, stationName);
        checkInTime.put(id, t);
    }
    public void checkOut(int id, String stationName, int t) {
        String startStation = checkInStation.get(id);
        int startTime = checkInTime.get(id);
        int travelTime = t - startTime;
        String route = startStation + "#" + stationName;
        if (!travelData.containsKey(route)) {
            travelData.put(route, new double[]{0, 0});
        }
        double[] data = travelData.get(route);
        data[0] += travelTime; 
        data[1] += 1;          
        checkInStation.remove(id);
        checkInTime.remove(id);
    }
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;
        double[] data = travelData.get(route);
        return data[0] / data[1];
    }
}

OUTPUT:
Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
Expected
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
