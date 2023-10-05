package Programmers.kit.sort;

import java.util.Arrays;

// LEVEL 2 -> H-Index
public class HIndex {

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = citations.length;

        int answer = 0;
        for (int i = max - 1; i >= 0; i--) {
            if (citations[i] < max - i) {
                return max - i - 1;
            }
            answer++;
        }

        return answer;
    }

    static class Answer {
        public int solution(int[] citations) {
            Arrays.sort(citations);

            int answer = 0;
            for (int i = 0; i < citations.length; i ++) {
                if (citations.length - i <= citations[i]) {
                    answer = citations.length - i;
                    break;
                } else if (citations.length - i >= citations[i]) {
                    answer = citations[i];
                }
            }
            return answer;
        }
    }
}
