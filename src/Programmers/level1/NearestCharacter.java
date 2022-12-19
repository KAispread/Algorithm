package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

/*
* 가장 가까운 같은 글자
* - Map.put() 이 같은 Key 가 있다면 기존 value를, 없다면 null을 리턴하는 것을 이용
* */
public class NearestCharacter {
    class Solution {
        public int[] solution(String s) {
            Map<Character, Integer> map = new HashMap<>();
            char[] sChar = s.toCharArray();

            int[] A = new int[sChar.length];
            for (int i = 0; i < sChar.length; i++) {
                char c = sChar[i];
                Integer before = map.put(c, i);

                if (before == null) {
                    A[i] = -1;
                } else {
                    A[i] = i - before;
                }
            }
            return A;
        }
    }
}
