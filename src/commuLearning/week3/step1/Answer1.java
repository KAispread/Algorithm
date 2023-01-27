package commuLearning.week3.step1;

import java.util.Arrays;

public class Answer1 {
    public int solution(String[][] clothes) {
        int answer = Arrays.stream(clothes)
                // 옷의 종류를 추출
                .map(c -> c[1])
                .distinct()
                // type -> 옷의 종류
                // 내부 Stream 으로 옷의 종류에 해당하는 것들을 차례대로 찾아서 셈
                .map(type -> (int) Arrays.stream(clothes)
                        .filter(c -> c[1].equals(type))
                        .count()
                )
                .map(c -> c + 1)
                // stream의 모든 값에 대한 연산 reduce
                // 초깃값 1, 이전 연산 값 * 다음 값
                .reduce(1, (c, n) -> c * n);

        return answer - 1;
    }
}
