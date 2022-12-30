package Programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* K번째 수
* */
public class NumberOfK {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] slice;

        for (int count = 0; count < commands.length; count++) {
            int start = commands[count][0];
            int end = commands[count][1];
            int target = commands[count][2];

            slice = cutElements(start - 1, end - 1, array);
            Arrays.sort(slice);
            answer[count] = slice[target - 1];
        }
        return answer;
    }

    private int[] cutElements(int startIdx, int endIdx, int[] target) {
        int[] slice = new int[endIdx - startIdx + 1];
        int count = 0;

        for (int i = startIdx; i <= endIdx; i++) {
            slice[count] = target[i];
            count++;
        }
        return slice;
    }
}
