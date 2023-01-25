package commuLearning.week3.step1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* 위장 - 정답
* */
public class Question1 {
    public int solution(String[][] clothes) {
        Map<String, Integer> c = new HashMap<>();

        for (String[] cl : clothes) {
            c.put(cl[1], c.getOrDefault(cl[1], 0) + 1);
        }

        int answer = 1;

        for (Map.Entry<String, Integer> entry : c.entrySet()) {
            // 부위별로 아무것도 입지 않는 경우 -> +1
            int v = entry.getValue() + 1;
            answer *= v;
        }

        // 아무것도 입지 않는 경우 제외
        return answer - 1;
    }
}
