package commuLearning.week1.step2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* 가장 큰 수 답
* */
public class Answer1 {
    public String solution(int[] numbers) {
        String answer = IntStream.of(numbers).mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());
        if (answer.startsWith("0")) {
            return "0";
        }
        return answer;
    }
}
