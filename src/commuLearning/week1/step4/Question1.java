package commuLearning.week1.step4;

import java.util.Arrays;

/*
* 숫자게임
* while 루프를 돌면서 시뮬레이션
* */
public class Question1 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int idxA = 0;
        int idxB = 0;
        int count = 0;

        while (idxB < B.length && idxA < A.length) {
            if (A[idxA] < B[idxB]) {
                idxB++;
                idxA++;
                count++;
            } else {
                idxB++;
            }
        }

        return count;
    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);
            int index = B.length - 1;

            int answer = 0;
            for (int i = A.length - 1; i >= 0; i-- ) {
                if (A[i] < B[index]) {
                    answer++;
                    index--;
                }
            }

            return answer;
        }
    }
}
