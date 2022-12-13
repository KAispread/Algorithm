package Programmers.level0;

import java.util.PriorityQueue;
import java.util.Queue;

/*
* 특이한 정렬
* */
public class IllegalSort {
    public static void main(String[] args) {

    }

    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Integer pivot = n;
        Queue<Integer> queue = new PriorityQueue<>(
                (a, b) -> {
                    int gapA = Math.abs(a - pivot);
                    int gapB = Math.abs(b - pivot);

                    if (gapA == gapB) {
                        return b - a;
                    }
                    return gapA - gapB;
                }
        );
        for (int num : numlist) {
            queue.add(num);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}
