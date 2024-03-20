import java.util.*;

class Solution {
    // 가지고 있는 카드 List<Integer> own;
    // 받게될 카드 List<Integer> addition;
    // 매 라운드때마다 받게될 카드에 2개씩 추가
    // 1. 가지고 있는 카드에서 냄
    // 2. 가지고 있는 카드 + 받게될 카드에서 냄 (코인 1개 차감)
    // 3. 받게 될 카드에서 냄 (코인 2개 차감)
    public int solution(int coin, int[] cards) {
        int round = 0;
        int ownCount = cards.length / 3;
        int index = ownCount;
        int target = cards.length + 1;
        
        List<Integer> own = new ArrayList<>();
        List<Integer> addition = new ArrayList<>();
        
        for (int i = 0; i < ownCount; i++) {
            own.add(cards[i]);
        }
        
        for (int i = 1; i <= (cards.length - ownCount) / 2; i++) {
            addition.add(cards[index++]);
            addition.add(cards[index++]);
            round = i;
            
            if (isGivenOwn(own, target)) {
                
            } else if (coin >= 1 && isGivenOwnAddition(own, addition, target)) {
                coin -= 1;
            } else if (coin >= 2 && isGivenAddition(addition, target)) {
                coin -= 2;
            } else {
            
                return round;
            }
        }
        
        return round + 1;
    }
    
    private boolean isGivenOwn(List<Integer> own, int target) {
        for (int i = 0; i < own.size() - 1; i++) {
            for (int j = i + 1; j < own.size(); j++) {
                Integer a = own.get(i);
                Integer b = own.get(j);
                
                if (a + b == target) {
                    own.remove(a);
                    own.remove(b);
                    
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isGivenOwnAddition(List<Integer> own, List<Integer> addition, int target) {
        for (int i = 0; i < own.size(); i++) {
            for (int j = 0; j < addition.size(); j++) {
                Integer a = own.get(i);
                Integer b = addition.get(j);
                
                if (a + b == target) {
                    own.remove(a);
                    addition.remove(b);
                    
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isGivenAddition(List<Integer> addition, int target) {
        for (int i = 0; i < addition.size() - 1; i++) {
            for (int j = i + 1; j < addition.size(); j++) {
                Integer a = addition.get(i);
                Integer b = addition.get(j);
                
                if (a + b == target) {
                    addition.remove(a);
                    addition.remove(b);
                    
                    return true;
                }
            }
        }
        
        return false;
    }
}