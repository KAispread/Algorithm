package commuLearning.week2;

import java.util.Arrays;

public class Question2 {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);

        int pIdx = 0;
        int tIdx = 0;

        while (tIdx < tshirts.length &&
                pIdx < people.length) {
            if (tshirts[tIdx] >= people[pIdx]) {
                tIdx++;
                pIdx++;
                answer++;
            } else {
                tIdx++;
            }
        }

        return answer;
    }
}
