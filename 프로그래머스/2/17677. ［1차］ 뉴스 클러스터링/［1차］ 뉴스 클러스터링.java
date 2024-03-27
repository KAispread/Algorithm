import java.util.*;

class Solution {
    Map<String, Integer> mapA;
    Map<String, Integer> mapB;
    
    public int solution(String str1, String str2) {
        mapA = new HashMap<>();
        mapB = new HashMap<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i+2);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                mapA.put(s, mapA.getOrDefault(s, 0) + 1);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i+2);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                mapB.put(s, mapB.getOrDefault(s, 0) + 1);
            }
        }
        
        int union = getUnion();
        int sum = getSum();
        
        if (str1.equals(str2)) return 65536;
        return (int) Math.floor(((double) union / sum) * 65536);  
    }
    
    private int getUnion() {
        int count = 0;
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            String key = entry.getKey();
            
            if (mapB.containsKey(key)) {
                count += Math.min(entry.getValue(), mapB.get(key));
            }
        }
        
        System.out.println(count);
        return count;
    }
    
    private int getSum() {
        Set<String> set = new HashSet<>();

        int count = 0;
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            String key = entry.getKey();
            if (set.contains(key)) continue;

            set.add(key);
            if (mapB.containsKey(key)) {
                count += Math.max(entry.getValue(), mapB.get(key));
                continue;
            }

            count += entry.getValue();
        }

        for (Map.Entry<String, Integer> entry : mapB.entrySet()) {
            String key = entry.getKey();
            if (set.contains(key)) continue;

            set.add(key);
            if (mapB.containsKey(key)) {
                count += Math.max(entry.getValue(), mapB.get(key));
                continue;
            }

            count += entry.getValue();
        }

        return count;
    }
}