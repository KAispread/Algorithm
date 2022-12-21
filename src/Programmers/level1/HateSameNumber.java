package Programmers.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 같은 숫자는 싫어
* */
public class HateSameNumber {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
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
