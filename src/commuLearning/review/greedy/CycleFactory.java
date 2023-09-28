package commuLearning.review.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LEVEL3 - 자전거 공장
public class CycleFactory {

    // 14.2 // 100
    static class Try {
        public static List<Cost> costList = new ArrayList<>();

        public int solution(int[][] cost, int[][] order) {
            Arrays.sort(order, (o1, o2) -> o1[0] - o2[0]);

            for (int i = 0; i < cost.length - 1; i++) {
                int amount = cost[i+1][0] - cost[i][0];
                int credit = cost[i][1];

                costList.add(new Cost(amount, credit));
            }
            costList.add(new Cost(Integer.MAX_VALUE, cost[cost.length-1][1]));

            int maxMonth = order[order.length - 1][0]; // 마지막 달
            int require = 0; // 총 필요 개수
            for(int[] o : order) {
                require += o[1];
            }

            int answer = 0;
            for (int c = 0; c < costList.size(); c++) {
                // 구간 별 Cost
                Cost costs = costList.get(c);

                for (int i = 1; i <= maxMonth; i++) {
                    if (require - costs.amount > 0) {
                        require -= costs.amount;
                        answer += costs.credit * costs.amount;
                    } else if (require > 0) {
                        answer += costs.credit * require;
                        require = 0;
                    }

                    if (require <= 0) {
                        break;
                    }
                }

                if (require <= 0) {
                    break;
                }
            }

            return answer;
        }

        static class Cost {
            // 개수 제한
            int amount;
            // 비용
            int credit;
            // 생산 개수
            int cost;

            public Cost(int amount, int credit) {
                this.amount = amount;
                this.credit = credit;
                this.cost = 0;
            }

            public void add(int c) {
                this.cost += c;
            }
        }
    }

    static class Answer {
        static final int INCENTIVE = 10_000;

        public int solution(int[][] cost, int[][] order) {
            int answer = 0;

            int maxMonth = 0;
            for (int[] o : order) maxMonth = Math.max(maxMonth, o[0]);

            int[] monthlyOrder = new int[maxMonth];
            int need = 0;
            int made = 0;
            for (int[] o : order) {
                monthlyOrder[o[0] - 1] += o[1];
                need += o[1];
            }

            for (int i = 0; i < cost.length - 1; i++) {
                if (need == 0 || made >= need) break;

                int price = cost[i][1];
                int limit = cost[i + 1][0] - cost[i][0];
                int rest = 0;

                for (int j = 0; j < maxMonth; j++) {
                    if (need == 0 || made >= need) break;

                    int making = Math.min(limit, need - made);

                    answer += making * price;
                    made += making;
                    need -= monthlyOrder[j];

                    if (monthlyOrder[j] == 0) continue;

                    int delivery = Math.min(made, monthlyOrder[j]);

                    made -= delivery;
                    monthlyOrder[j] -= delivery;
                    rest += monthlyOrder[j];
                }

                need = rest;
                made = 0;
            }

            answer += need * cost[cost.length - 1][1];
            return answer;
        }
    }

}
