import java.util.*;
import java.util.stream.*;

class Solution {
    
    private int defaultTime;
    private int defaultFee;
    private int addTime;
    private int addFee; 
    private Map<Integer, ParkTime> parkMap = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        setUp(fees);
        
        for (String record : records) {
            String[] recordArr = record.split(" ");
            String time = recordArr[0];
            int number = Integer.parseInt(recordArr[1]);
            String type = recordArr[2];
            
            ParkTime pk = parkMap.getOrDefault(number, new ParkTime(number, time));
            
            if (type.equals("IN") && parkMap.containsKey(number)) {
                pk.reEnter(time);
            } else if (type.equals("IN") && !parkMap.containsKey(number)) {
                parkMap.put(number, pk);
            } else {
                pk.out(time);
            }
        }
        
        List<ParkTime> parkList = new ArrayList<>();
        for (Map.Entry<Integer, ParkTime> entry : parkMap.entrySet()) {
            parkList.add(entry.getValue());
        }
        
        return parkList.stream()
            .sorted((o1, o2) -> o1.number - o2.number)
            .mapToInt((o1) -> {
                int total = o1.calcTotal();
                int fee = 0;
                
                if (total <= defaultTime) {
                    return defaultFee;
                }
                
                fee += defaultFee;
                int remainTime = total - defaultTime;
                
                int upperFlag = remainTime % addTime;
                int remainAddTime = remainTime / addTime;
                
                if (upperFlag > 0) return fee + (remainAddTime + 1) * addFee;
                return fee + remainAddTime * addFee;
            }).toArray();
    }
    
    private void setUp(int[] fees) {
        defaultTime = fees[0];
        defaultFee = fees[1];
        addTime = fees[2];
        addFee = fees[3];
    }
    
    static class ParkTime {
        
        int number;
        int total;
        int lastEnter;
        boolean isOut;
        
        public ParkTime(int number, String lastEnter) {
            this.number = number;
            this.lastEnter = convertTimeToInt(lastEnter);
            this.total = 0;
            this.isOut = false;
        }
        
        public void out(String outTime) {
            int outIntTime = convertTimeToInt(outTime);
            int gap = outIntTime - this.lastEnter;
            
            this.total += gap;
            this.isOut = true;
        }
        
        private int convertTimeToInt(String time) {
            String[] splitTime = time.split(":");
            int hour = Integer.parseInt(splitTime[0]) * 60;
            int minute = Integer.parseInt(splitTime[1]);
            
            return hour + minute;
        }
        
        public void reEnter(String enterTime) {
            this.lastEnter = convertTimeToInt(enterTime);
            this.isOut = false;
        }
        
        public int calcTotal() {
            if (this.isOut) return total;
            
            int gap = convertTimeToInt("23:59") - this.lastEnter;
            return this.total + gap;
        }
    }
}
