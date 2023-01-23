package commuLearning.week2;

import java.util.Arrays;

public class Answer2 {
    public int solution(int[] people, int[] tshirts) {
        Arrays.sort(people);
        Arrays.sort(tshirts);

        int answer = 0;

        int i = tshirts.length - 1;
        for (int j = people.length - 1; j >= 0 && i >= 0; j--) {
            if (tshirts[i] >= people[j]) {
                answer += 1;
                i -= 1;
            }
        }

        return answer;
    }
}
