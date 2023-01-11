package commuLearning.week1.step2;

import java.util.*;
/*
* 가장 큰 수
* 해결 여부 - O
* */
public class BiggestNumber {
    Queue<String> queue = new PriorityQueue<>(
            (o1, o2) -> {
                return (o2+o1).compareTo(o1+o2);
            }
    );

    public String solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            queue.offer(String.valueOf(numbers[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        String biggest = sb.toString();

        if (biggest.charAt(0) == '0') {
            return "0";
        }
        return biggest;
    }
}
