package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

/*
* 추억 점수
* */
public class MissScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> missMap = new HashMap<>();
        int[] result = new int[photo.length];

        for (int i = 0; i < name.length; i++) {
            missMap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                result[i] += missMap.getOrDefault(photo[i][j], 0);
            }
        }

        return result;
    }
}
