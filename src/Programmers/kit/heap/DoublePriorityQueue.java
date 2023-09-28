package Programmers.kit.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

// LEVEL3 - 이중 우선순위 큐
public class DoublePriorityQueue {

    static class Try {
        public static Queue<Integer> naturalQueue = new PriorityQueue<>();
        public static Queue<Integer> reverseQueue = new PriorityQueue<>(Comparator.reverseOrder());

        public static final String removeMax = "D 1";
        public static final String removeMin = "D -1";
        public static final String plusRegax = "I ";

        public static int[] solution(String[] operations) {
            int[] result = new int[2];

            for (String operation : operations) {
                // 삽입 연산일 경우
                if (operation.startsWith(plusRegax)) {
                    int number = Integer.parseInt(operation.replaceFirst(plusRegax, ""));
                    naturalQueue.offer(number);
                    reverseQueue.offer(number);
                    // 최댓값 삭제 연산일 경우
                } else if (!naturalQueue.isEmpty() && operation.equals(removeMax)) {
                    int max = reverseQueue.poll();
                    naturalQueue.remove(max);
                    // 최솟값 삭제 연산일 경우
                } else if (!naturalQueue.isEmpty() && operation.equals(removeMin)) {
                    int min = naturalQueue.poll();
                    reverseQueue.remove(min);
                }
            }

            if (naturalQueue.isEmpty()) {
                return result;
            }

            result[0] = reverseQueue.peek();
            result[1] = naturalQueue.peek();
            return result;
        }
    }

    static class Answer {
        static Queue<Integer> min = new PriorityQueue<>();
        static Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        public static int[] solution(String[] operations) {
            for (String oper : operations) {
                operation(oper);
            }

            if (min.isEmpty()) {
                return new int[] {0, 0};
            }

            List<Integer> answer = new ArrayList<>();
            answer.addAll(min);

            Collections.sort(answer, Comparator.reverseOrder());
            return new int[] {answer.get(0), answer.get(answer.size() - 1)};
        }

        private static void operation(String oper) {
            String[] devide = oper.split(" ");
            if (Objects.equals(devide[0], "I")) {
                addNumber(devide[1]);
            } else if (Objects.equals(devide[1], "-1")) {
                rmMin();
            } else {
                rmMax();
            }
        }

        private static void addNumber(String num) {
            Integer n = Integer.parseInt(num);
            max.add(n);
            min.add(n);
        }

        private static void rmMax() {
            if (!max.isEmpty()) {
                Integer poll = max.poll();
                min.remove(poll);
            }
        }

        private static void rmMin() {
            if (!min.isEmpty()) {
                Integer poll = min.poll();
                max.remove(poll);
            }
        }
    }

}
