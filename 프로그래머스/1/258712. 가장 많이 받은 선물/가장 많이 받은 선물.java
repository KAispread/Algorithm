import java.util.*;

class Solution {
    // 선물 지수는 Map에 저장
    // 서로 주고 받은 선물은 2차원 배열에 저장
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> giftRate = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        
        for (int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
        }
        
        // A 가 B에게 준 선물 개수 = gift[A][B];
        int[][] gift = new int[friends.length][friends.length];
        
        for (int i = 0; i < gifts.length; i++) {
            String[] g = gifts[i].split(" ");
            String giver = g[0];
            String reciever = g[1];
            
            // 선물 지수 update
            giftRate.put(giver, giftRate.getOrDefault(giver, 0) + 1);
            giftRate.put(reciever, giftRate.getOrDefault(reciever, 0) - 1);
            
            // 누가 누구에게 줬는지 update
            int giverIdx = index.get(giver);
            int receiverIdx = index.get(reciever);
            
            gift[giverIdx][receiverIdx] += 1;
        }
        
        int[] count = new int[friends.length];
        int answer = 0;
        
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {    
                int givenA = gift[i][j];
                int givenB = gift[j][i];
                
                if (givenA > givenB) count[i] += 1;
                else if (givenB > givenA) count[j] += 1;
                else {
                    int rateA = giftRate.getOrDefault(friends[i], 0);
                    int rateB = giftRate.getOrDefault(friends[j], 0);
                    
                    if (rateA > rateB) count[i] += 1;
                    else if (rateB > rateA) count[j] += 1;
                }
            }
        }
        
        for (int i = 0; i < count.length; i++) {
            answer = Math.max(answer, count[i]);
        }
        
        return answer;
    }
}