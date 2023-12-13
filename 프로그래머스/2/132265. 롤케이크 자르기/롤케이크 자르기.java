import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int count = 0;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int[] countA = new int[10001];
        int[] countB = new int[10001];
        setA.add(topping[0]);
        countA[topping[0]] = 1;
        
        for (int i = 1; i < topping.length; i++) {
            setB.add(topping[i]);
            countB[topping[i]] += 1;
        }
        
        if (isPair(setA, setB)) count++;
        
        for (int i = 1; i < topping.length - 1; i++) {
            int current = topping[i];
            countB[current] -= 1;
            if (countB[current] <= 0) setB.remove(current);
            
            countA[current] += 1;
            setA.add(current);
            
            if (isPair(setA, setB)) count++;
        }
            
        return count;
    }
    
    private boolean isPair(Set<Integer> setA, Set<Integer> setB) {
        if (setA.size() == setB.size()) return true;
        return false;
    }
}