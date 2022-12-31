package Programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

/*
* 더 맵게
* */
public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        Queue<Integer> priority = new PriorityQueue<>();
        for (int i : scoville) {
            priority.add(i);
        }
        int count = 0;
        while (priority.size() > 1 && priority.peek() < K) {
            int first = priority.poll();
            int second = priority.poll();
            int s = shake(first, second);
            priority.add(s);
            count++;
        }

        if (priority.peek() < K) {
            return -1;
        }

        return count;
    }

    private int shake(int first, int second) {
        return first + second * 2;
    }
}
