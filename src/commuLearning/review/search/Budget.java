package commuLearning.review.search;

import java.util.stream.IntStream;

// LEVEL 3 -> 예산
public class Budget {

    public int solutions(int[] budgets, int M) {
        int min = 0;
        int max = IntStream.of(budgets).max().orElse(0);

        int answer = 0;

        while (min <= max) {
            int mid = (max + min) / 2;
            int sum = 0;

            for (int b : budgets) {
                if (b > mid) {
                    sum += mid;
                } else {
                    sum += b;
                }
            }

            if (sum > M) {
                max = mid - 1;
            } else {
                answer = mid;
                min = mid + 1;
            }
        }

        return answer;
    }

    public int solution(int[] budgets, int M) {
        int answer = 0;

        int min = 0;
        int max = IntStream.of(budgets).max().orElse(0);

        while (min <= max) {
            int mid = (max + min) / 2;

            int sum = 0;
            for (int b : budgets) {
                if (b > mid) {
                    sum += mid;
                } else {
                    sum += b;
                }
            }

            if (sum > M) {
                max = mid - 1;
            } else if (sum <= M) {
                answer = mid;
                min = mid + 1;
            }
        }

        return answer;
    }

}
