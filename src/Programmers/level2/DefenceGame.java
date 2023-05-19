package Programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

/*
* 디펜스 게임
* */
public class DefenceGame {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int sum = 0;

        for (int i = 0; i < enemy.length; i++) {
            int now = enemy[i];
            queue.offer(now);
            sum += now;

            while (sum > n && k > 0) {
                int removed = queue.poll();
                sum -= removed;
                k--;
            }

            if (sum > n) return i;
        }

        return enemy.length;
    }
}
