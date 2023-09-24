package Programmers.kit.heap;

import java.util.PriorityQueue;
import java.util.Queue;

// LEVEL2 - 더 맵게
public class MoreSpicy {

    /*
    모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
    => 두번째로 맵지 않은 음식이 0 일 때
    */
    public static class Try {
        public int solution(int[] scoville, int K) {
            Queue<Integer> priority = new PriorityQueue<>();

            for (int s : scoville) {
                priority.offer(s);
            }

            int count = 0;
            while (priority.size() >= 2 && K > priority.peek()) {
                final int first = priority.poll();
                final int second = priority.poll();

                if (!isPossible(first, second)) return -1;

                int newScoville = first + second * 2;
                priority.offer(newScoville);
                count++;
            }

            if (K > priority.peek()) {
                return -1;
            }

            return count;
        }

        public boolean isPossible(int first, int second) {
            if (second == 0) {
                return false;
            }

            return true;
        }
    }

    public static class Answer {
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
}
