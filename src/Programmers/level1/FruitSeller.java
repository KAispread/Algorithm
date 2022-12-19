package Programmers.level1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 과일 장수
* */
public class FruitSeller {
    public int solution(int k, int m, int[] score) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int scr : score) {
            queue.add(scr);
        }
        int answer = 0;
        while (queue.size() >= m) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < m; i++) {
                int poll = queue.poll();
                if (min > poll) {
                    min = poll;
                }
            }
            answer += min * m;
        }

        return answer;
    }
}
