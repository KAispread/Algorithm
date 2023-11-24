import java.util.*;

class Solution {
    
    Map<String, Integer> numberMap = Map.of(
        "zero", 0,
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9
    );
    
    public int solution(String s) {
        String temp = s;
        
        for (Map.Entry<String, Integer> map : numberMap.entrySet()) {
            String key = map.getKey();
            String value = String.valueOf(map.getValue());
            
            temp = temp.replaceAll(key, value);
        }
        
        return Integer.parseInt(temp);
    }
    
}