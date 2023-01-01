package Programmers.level3;

import java.util.*;

/*
* 이중 우선순위 큐
* */
public class DoublePriorityQueue {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
    }

    static Queue<Integer> min = new PriorityQueue<>();
    static Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

    public static int[] solution(String[] operations) {
        
        for (String oper : operations) {
            operation(oper);
        }

        List<Integer> answer = new ArrayList<>();
        answer.addAll(min);

        if (answer.isEmpty()) {
            return new int[] {0, 0};
        } else if (answer.size() == 1) {
            int a = answer.get(0);
            return new int[] {a, a};
        }

        Collections.sort(answer);
        return new int[] {answer.get(answer.size() - 1), answer.get(0)};
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
