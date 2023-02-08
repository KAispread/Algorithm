package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class LottoMaxMin {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6,1);
        map.put(5,2);
        map.put(4,3);
        map.put(3,4);
        map.put(2,5);

        int removed = 0;
        int collect = 0;
        for (int l : lottos) {
            if (l == 0) {
                removed++;
                continue;
            }

            for (int w : win_nums) {
                if (w == l) {
                    collect++;
                    break;
                }
            }
        }
        int[] answer = new int[2];
        answer[1] = map.getOrDefault(collect, 6);
        answer[0] = map.getOrDefault(collect + removed, 6);

        return answer;
    }
}
