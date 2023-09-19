package Programmers.kit.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LEVEL 1 -> 같은 숫자는 싫어
public class HateSameNumber {

    public int[] solution(int []arr) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);

        for (int num : arr) {
            int savedNum = queue.peekLast();
            if (savedNum != num) {
                queue.add(num);
            }
        }

        return queue.stream().mapToInt(n -> n).toArray();
    }

    public int[] answer(int []arr) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        int before = -1;
        for (int given : arr) {
            if (before != given) {
                answer.add(given);
                before = given;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
