import java.util.*;

// 사칙연산 + - / % *

class Solution {
    
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        Set<Integer> set = new HashSet<>();
        set.add(N);
        map.put(1, set);
        int answer = 0;
        
        for (int i = 2; i <= 8; i++) {
            Set<Integer> dump = new HashSet<>();
            dump.add(getNumer(i, N));
            
            int left = 1;
            int right = i - 1;
                
            while (left < i) {
                Set<Integer> lDump = map.get(left);
                Set<Integer> rDump = map.get(right);
                
                for (int l : lDump) {
                    if (l == 0) continue;
                    
                    for (int r : rDump) {
                        if (r == 0) continue;    
                        dump.add(l + r);
                        dump.add(l * r);
                        dump.add(l - r); 
                        dump.add(l / r);
                        
                    }
                }
                
                left++;
                right--;
            }
            
            if (dump.contains(number)) {
                return i;
            }
            map.put(i, dump);
        }
        
        if (answer == 0) return -1;
        return answer;
    }
    
    private int getNumer(int count, int N) {
        String number = String.valueOf(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(number);
        }
        
        return Integer.parseInt(sb.toString());
    }
}