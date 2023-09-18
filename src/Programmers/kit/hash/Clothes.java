package Programmers.kit.hash;

import java.util.HashMap;
import java.util.Map;

// LEVEL 2 - 의상
public class Clothes {
    public int solution(String[][] clothes) {
        Map<String, Integer> pool = new HashMap<>();

        for (String[] clothe : clothes) {
            String specifies = clothe[1];
            pool.put(specifies, pool.getOrDefault(specifies, 0) + 1);
        }

        int result = 1;
        for (Map.Entry<String, Integer> entry : pool.entrySet()) {
            result *= entry.getValue() + 1;
        }

        return result - 1;
    }

    public int answer(String[][] clothes) {
        Map<String, Integer> clotheMap = new HashMap<>();
        for (String[] cloth : clothes) {
            clotheMap.put(cloth[1], clotheMap.getOrDefault(cloth[1], 0) + 1);
        }

        int count = 1;
        for (Map.Entry<String, Integer> entry : clotheMap.entrySet()) {
            count *= entry.getValue() + 1;
        }

        return count - 1;
    }
}
