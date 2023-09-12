package Programmers.kit.hash;


import java.util.HashMap;
import java.util.Map;

public class Phoneketmon {
    public int solution(int[] nums) {
        Map<Integer, Integer> ket = new HashMap<>();
        for (int num : nums) {
            ket.put(num, ket.getOrDefault(num, 0) + 1);
        }

        int max = nums.length / 2;
        int ketSize = ket.size();

        return Math.min(max, ketSize);
    }

    // 이전 답
    public int answer(int[] nums) {
        Map<Integer, Integer> poncket = new HashMap<>();
        for (int num : nums) {
            poncket.put(num, poncket.getOrDefault(num, 0) + 1);
        }

        int size = poncket.size();
        int pick = nums.length / 2;
        if (size > pick) {
            return pick;
        }
        return size;
    }
}
