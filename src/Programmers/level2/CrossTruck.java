package Programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CrossTruck {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> wait = new LinkedList<>();
        for (int w : truck_weights) {
            wait.offer(new Truck(w));
        }
        Queue<Truck> onBridge = new LinkedList<>();

        int currentWeight = 0;
        int time = 0;
        while (!wait.isEmpty() || !onBridge.isEmpty()) {
            time++;
            if (!onBridge.isEmpty()) {
                for (Truck bridge : onBridge) {
                    bridge.addPosition(1);
                }
                if (onBridge.peek().getPosition() > bridge_length) {
                    Truck poll = onBridge.poll();
                    currentWeight -= poll.getWeight();
                }
            }

            if (!wait.isEmpty()) {
                if (weight >= currentWeight + wait.peek().getWeight()) {
                    Truck poll = wait.poll();
                    onBridge.offer(poll);
                    currentWeight += poll.getWeight();
                    continue;
                }
            }

            if (!onBridge.isEmpty()) {
                int forward = bridge_length - onBridge.peek().getPosition();
                if (forward == 0) {
                    continue;
                }
                for (Truck bridge : onBridge) {
                    bridge.addPosition(forward);
                    time += forward;
                }
            }
        }
        return time;
    }
    static class Truck {
        private int weight;
        private int position = 1;

        public Truck(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getPosition() {
            return this.position;
        }

        public void addPosition(int forward) {
            this.position += forward;
        }
    }

    /*
    * H-Index
    * 1 - 배열 요소의 값이 남은 배열 길이와 같은 경우 => 요소값 return
    * 2 - 배열 요소의 값이 남은 배열 길이보다 큰 경우 => 배열 길이 return
    * 3 - 배열 요소의 값이 남은 배열 길이보다 작은 경우 => 요소 값 저장 후 answer return
    * */
    public static class HIndex {
        public int solution(int[] citations) {
            Arrays.sort(citations);

            int answer = 0;
            for (int i = 0; i < citations.length; i ++) {
                if (citations.length - i <= citations[i]) {
                    answer = citations.length - i;
                    break;
                } else if (citations.length - i >= citations[i]) {
                    answer = citations[i];
                }
            }
            return answer;
        }
    }
}
