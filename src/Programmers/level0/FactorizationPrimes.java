package Programmers.level0;

import java.util.PriorityQueue;
import java.util.Queue;

/*
* 소인수분해
* */
public class FactorizationPrimes {
    public int[] solution(int n) {
        Queue<Integer> priority = new PriorityQueue<>();
        int a = n;
        for (int i = 2; i < n / 2; i++) {
            while (a % i == 0 && a >= i) {
                priority.offer(i);
                a /= i;
            }
        }
        if (a != 0 && a != 1) {
            priority.offer(a);
        }
        Integer[] buffer = priority.stream().distinct().toArray(Integer[]::new);
        int[] answer = new int[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            answer[i] = buffer[i];
        }
        return answer;
    }
}
