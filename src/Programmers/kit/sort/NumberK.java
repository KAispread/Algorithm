package Programmers.kit.sort;

import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LEVEL 1 - K번째수
public class NumberK {

    static class Try {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int start = commands[i][0];
                int end = commands[i][1];
                int index = commands[i][2] - 1;

                List<Integer> list = new ArrayList<>();

                for (int j = start - 1; j < end; j++) {
                    list.add(array[j]);
                }

                answer[i] = getSortedK(list, index);
            }

            return answer;
        }

        private int getSortedK(List<Integer> arr, int k) {
            sort(arr);

            return arr.get(k);
        }
    }

    static class Anwer {

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
}
