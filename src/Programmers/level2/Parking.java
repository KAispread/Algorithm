package Programmers.level2;

import java.util.*;

/*
 * 주차장
 * */
public class Parking {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, String[]> parking = new TreeMap<>();

        for (String record : records) {
            String[] rec = record.split(" ");
            String time = rec[0];
            int number = Integer.parseInt(rec[1]);
            String flag = rec[2];

            if (!parking.containsKey(rec[1])) {
                parking.put(number, new String[]{time, "0", flag});
            } else {
                String[] info = parking.get(number);
                if (rec[2].equals("IN")) {
                    info[0] = time;
                } else {
                    int total = Integer.parseInt(info[1]);
                    info[1] = String.valueOf(outCar(info[0], time, total));
                    info[2] = flag;
                }
                info[2] = flag;
            }
        }

        for (String[] car : parking.values()) {
            if (car[2].equals("IN")) {
                car[1] = String.valueOf(outCar(car[0], "23:59", Integer.parseInt(car[1])));
            }
        }

        int[] answer = new int[parking.size()];
        int cnt = 0;
        for (String[] car : parking.values()) {
            int time = Integer.parseInt(car[1]);
            if (time <= fees[0]) {
                answer[cnt] = fees[1];
                cnt++;
                continue;
            }
            answer[cnt] = fees[1] + ((int) Math.ceil((time - fees[0]) / fees[2])) * fees[3];
            cnt++;
        }

        return answer;
    }

    private int outCar(String in, String out, int total) {
        int[] outHM = devideTime(out);
        int[] inHM = devideTime(in);

        int hour = (outHM[0] - inHM[0]) * 60;
        int minute = outHM[1] - inHM[1];
        return total += (hour + minute);
    }

    private int[] devideTime(String time) {
        String[] devide = time.split(":");
        int H = Integer.parseInt(devide[0]);
        int M = Integer.parseInt(devide[1]);
        return new int[]{H, M};
    }
}
