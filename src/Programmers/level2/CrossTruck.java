package Programmers.level2;

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
}
