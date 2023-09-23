package Programmers.kit.stack_queue;

import java.util.LinkedList;

// 다리를 지나는 트럭
public class CrossBridgeTruck {

    /*
    1. 트럭 하나가 다리에 진입해서 완전히 나오는데 까지 걸리는 시간은 bridge_length + 1 이다.
    2. weight 가 버티는 한, 트럭은 계속해서 순차적으로 다리에 진입한다.
    3. weight 가 버티지 못하거나, queue에 트럭이 없다면
        bridge_length - 맨 앞에있는 트럭의 위치 + 1을 모든 다리 위에 있는 트럭에 적용한다. (맨 앞 트럭 out)
    4. Queue 에 모든 원소가 없을때까지 반복한다.
    */
    static class Truck {

        int location;
        int weight;

        public Truck(int location, int weight) {
            this.location = location;
            this.weight = weight;
        }

        public void forward() {
            this.location++;
        }

        public void forward(int length) {
            this.location += length;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Truck> queue = new LinkedList<>();
        int truckIndex = 0;
        int truckWeightOnBridge = 0;
        int time = 0;

        for (int t : truck_weights) {
            // 새 트럭이 들어갈 수 있을만큼 시간을 넘김
            while (truckWeightOnBridge + t > weight) {
                Truck polledTruck = queue.poll();
                int forward = bridge_length - polledTruck.location + 1;
                truckWeightOnBridge -= polledTruck.weight;
                time += forward;

                for (Truck tr : queue) {
                    tr.forward(forward);
                }
            }

            truckWeightOnBridge += t;
            queue.offer(new Truck(1, t));
            time++;

            for (Truck tr : queue) {
                tr.forward();
            }

            if (bridge_length < queue.peek().location) {
                truckWeightOnBridge -= queue.poll().weight;
            }
        }
        time++;

        if (!queue.isEmpty()) {
            return time + (bridge_length - queue.peekLast().location + 1);
        }
        return time;
    }

}
