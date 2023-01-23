package commuLearning.week1.step1;

import java.util.Arrays;

/*
* 자전거 공장
* 해결 여부 - X
* */
public class ElectronicPrice {
    private int[][] price;

    public int solution(int[][] cost, int[][] order) {
        price = new int[cost.length - 3][3];
        Arrays.sort(order, (int[] o1, int[] o2) -> {return o1[0] - o2[0];});

        for (int i = 0; i < cost.length - 1; i++) {
            price[i][0] = cost[i][0];
            price[i][1] = cost[i+1][0];
            price[i][2] = cost[i][1];
        }

        int money = 0;
        int cycle = 0;
        int premonth = 0;

        int[] level = new int[price.length];

        for (int[] o : order) {
            int month = o[0];
            int require = o[1];

            int IDX = 0;
            cycle += (price[IDX][1] - price[IDX][0]) * (month - premonth);

            if (cycle >= require) {
                premonth = month;
                money += (month - premonth) * (price[IDX][1] - price[IDX][0]) * price[IDX][2];
                continue;
            }

            IDX++;
            while (require < (cycle + (price[IDX][1] - price[IDX][0]) * (month - level[IDX]))
                && IDX < price.length) {
                level[IDX] = month;
                IDX++;
            }

            premonth = month;
        }
        int answer = 123;
        return answer;
    }
}
