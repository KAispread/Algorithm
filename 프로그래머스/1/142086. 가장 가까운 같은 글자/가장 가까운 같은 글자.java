import java.util.*;

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