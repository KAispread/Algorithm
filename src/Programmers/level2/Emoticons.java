package Programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 이모티콘 할인 행사
* */
public class Emoticons {
    public static void main(String[] args) {
        solution(new int[][] {{40, 10000}, {25, 10000}}, new int[] {7000, 9000});
    }

    static Set<String> visited = new HashSet<>();
    static int[] result = new int[] {0, 0};

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        Arrays.fill(discount, 40);

        getRate(users, emoticons, discount);
        return result;
    }

    private static void getRate(int[][] users, int[] emoticons, int[] discount) {
        int[] current = new int[emoticons.length];
        visited.add(Arrays.toString(discount));
        // 현재 가격 초기화
        for (int i = 0; i < current.length; i++) {
            current[i] = emoticons[i] - emoticons[i] * discount[i] / 100;
        }

        int plusSubscriber = 0;
        int amount = 0;
        for (int i = 0; i < users.length; i++) {
            int total = 0;
            boolean plus = false;

            for (int e = 0; e < current.length; e++) {
                if (discount[e] >= users[i][0]) total += current[e];

                if (total >= users[i][1]) {
                    plusSubscriber++;
                    plus = true;
                    break;
                }
            }

            if (!plus) amount += total;
        }

        if (result[0] < plusSubscriber) {
            result[0] = plusSubscriber;
            result[1] = amount;
        } else if (result[0] == plusSubscriber && result[1] < amount) {
            result[0] = plusSubscriber;
            result[1] = amount;
        }

        int[] copy = Arrays.copyOf(discount, discount.length);
        for (int i = 0; i < discount.length; i++) {
            if (copy[i] >= 20) {
                copy[i] -= 10;
                if (visited.contains(Arrays.toString(copy))) {
                    copy[i] += 10;
                    continue;
                }
                getRate(users, emoticons, copy);
                copy[i] += 10;
            }
        }
    }
}
