import java.util.*;

/*
1개로 잘랐을 때 부터 문자열 길이 / 2 로 잘랐을 때 만큼 반복 
자른 문자열 Queue에 저장 후 poll()하여 판별 int 변수를 통해 몇 번 반복되었는지 count
pool()한 문자열과 다음 문자열이 같다면 count++
다르다면 count = 1 후 문자열 길이 +
(문자열 길이 + 기준)
pool 한 문자열 길이 + count [count가 1이면 0 10 미만이면 1 10이상이면 2 100 이상이면 3 1000이상이면 4]
*/
class Solution {
    
    private int min = 0;
    
    public int solution(String s) {
        min = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            List<String> devide = devideString(s, i);
        
            
            String before = devide.get(0);
            int count = 1;
            int strLength = 0;
            
            for (int j = 1; j < devide.size(); j++) {
                String d = devide.get(j);
                
                if (d.equals(before)) {
                    count++;
                } else {
                    int cntLength = countLength(count);
                    strLength += before.length() + cntLength;
                    count = 1;
                }
                
                before = d;
            }
            
            strLength += countLength(count) + before.length();
            min = Math.min(strLength, min);
        }
        
        return min;
    }
    
    private int countLength(int count) {
        if (count == 1) return 0;
        else if (count > 1 && count < 10) return 1;
        else if (count >= 10 && count < 100) return 2;
        else if (count >= 100 && count < 1000) return 3;
        else return 4;
    }
    
    // number 만큼 s를 자름
    private List<String> devideString(String s, int number) {
        List<String> devide = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i += number) {
            int endIdx = i + number;
            if (endIdx > s.length()) endIdx = s.length();
            
            devide.add(s.substring(i, endIdx));
        }
        
        return devide;
    }
}