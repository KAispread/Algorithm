package Programmers.level1;

import java.util.ArrayList;
import java.util.List;

/*
* 모의고사
* */
public class DropMath {
    private int[][] dropMath = new int[][] {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int max = 0;
        int maxNum = 0;
        int[] students = new int[3];

        for (int i = 0; i < 3; i++) {
            int mathLoop = dropMath[i].length;
            int index = 0, mathIndex = 0;
            int score = 0;

            while (index < answers.length) {
                if (answers[index] == dropMath[i][mathIndex]) {
                    score++;
                }
                index++;
                mathIndex++;
                if (mathIndex >= mathLoop) {
                    mathIndex = 0;
                }
            }

            students[i] = score;
            if (students[i] >= max) {
                max = students[i];
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (max == students[i]) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(o -> o).toArray();
    }
}
