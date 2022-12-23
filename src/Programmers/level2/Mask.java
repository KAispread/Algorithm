package Programmers.level2;

import java.util.HashMap;
import java.util.Map;

/*
* 위장
* */
public class Mask {
    public static void main(String[] args) {

    }

    public int solution(String[][] clothes) {
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
