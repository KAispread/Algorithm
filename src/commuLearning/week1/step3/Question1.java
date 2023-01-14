package commuLearning.week1.step3;

import java.util.stream.IntStream;

/*
* 예산
* - 이분 탐색
* */
public class Question1 {
    public int solution(int[] budgets, int M) {
        int min = 0;
        // IntStream API를 사용하여 주어진 값에서 가장 큰 수를 구함
        int max = IntStream.of(budgets).max().orElse(0);

        int answer = 0;
        while (min <= max) {
            // 중간 값을 찾기 위해 최소 범위 + 최대 범위 / 2
            // Stream 에 들어가는 값은 불변이여야함
            final int mid = (min + max) / 2;

            int sum = IntStream.of(budgets).map(b -> Math.min(b, mid)).sum();
            if (sum <= M) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
}
