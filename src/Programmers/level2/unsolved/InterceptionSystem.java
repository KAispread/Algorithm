package Programmers.level2.unsolved;

import java.util.Arrays;

/*
* 요격 시스템
* */
public class InterceptionSystem {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int answer = 1;
        int end = targets[0][1];

        for (int[] target : targets) {
            if (target[0] >= end) {
                end = target[1];
                answer++;
            }
        }

        return answer;
    }
}
