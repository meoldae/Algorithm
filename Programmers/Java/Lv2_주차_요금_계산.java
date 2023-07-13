import java.util.*;

public class Lv2_주차_요금_계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Map<String, Integer> results = new TreeMap<>();
        Map<String, String> parkingRecord = new HashMap<>();
        for (String record : records) {
            String[] car = record.split(" ");
            if ("IN".equals(car[2])) {
                parkingRecord.put(car[1], car[0]);
            } else {
                String[] entrance = parkingRecord.get(car[1]).split(":");
                String[] departure = car[0].split(":");
                int interval = Integer.parseInt(departure[0]) * 60 + Integer.parseInt(departure[1]) -
                        (Integer.parseInt(entrance[0]) * 60 + Integer.parseInt(entrance[1]));

                if (results.containsKey(car[1])) {
                    results.put(car[1], results.get(car[1]) + interval);
                }else {
                    results.put(car[1], interval);
                }
                parkingRecord.remove(car[1]);
            }
        }

        for (String key : parkingRecord.keySet()) {
            String[] entrance = parkingRecord.get(key).split(":");
            int interval = 1439 - (Integer.parseInt(entrance[0]) * 60 + Integer.parseInt(entrance[1]));
            if (results.containsKey(key)){
                results.put(key, results.get(key) + interval);
            }else {
                results.put(key, interval);
            }
        }

        int[] answer = new int[results.size()];
        String[] keys = results.keySet().toArray(new String[0]);

        for(int i = 0; i < results.size(); i++) {
            answer[i] = calcFee(fees, results.get(keys[i]));
        }

        System.out.println(Arrays.toString(answer));
    }
    public static int calcFee(int[] fees, int interval) {
        if (interval < fees[0]) return fees[1];
        return fees[1]  + ((int) Math.ceil(((double) (interval - fees[0]) / fees[2])) * fees[3]);
    }
}
