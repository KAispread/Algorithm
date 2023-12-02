import java.util.*;

class Solution {
    public long solution(int[] weights) {
                long answer = 0;
        // 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 
        
        Arrays.sort(weights);
        
        int count = 0;
        for(int i=0; i<weights.length-1; i++){
            if(i>0){
                if(weights[i]==weights[i-1]){
                    count--;
                    answer += count;
                    continue;
                }
            }
            
            count = 0;
            
            for(int j=i+1; j<weights.length; j++){
                if(weights[i]==weights[j] || 
                   weights[i]*4==weights[j]*3 ||
                   weights[i]*3==weights[j]*2 ||
                   weights[i]*2==weights[j] ) {
                    count++;
                }
            }
            
            answer += count;
        }
        
        return answer;
    }
    
    private boolean isPair(int before, int after) {
        if (before == after) return true;
        if (before * 3 == after * 2) return true;
        if (before * 2 == after * 1) return true;
        if (before * 4 == after * 3) return true;
        return false;
    }

}