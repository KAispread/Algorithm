import java.util.*;

/*
맨 마지막 집부터 처리하는게 무조건 이득
그리디 알고리즘
맨 마지막 집에 대한 Index 저장
while (맨 마지막 인덱스 < 0)
택배 최대 수용 개수만큼 사이클마다 맨 마지막 집부터 배달 상자 개수를 차감함

*/
class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
       long answer = 0;
        //트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 return 
        
        int d = 0;
        int p = 0;
        for(int i=n-1; i>=0; i--){
            d -= deliveries[i];
            p -= pickups[i];
            
            while(d < 0 || p < 0){
                d += cap;
                p += cap;
                answer += (i+1)*2;
            }
        }
        
        return answer;
    }
    
    private void delivery(int[] deliveries, int lastIdx, int cap) {        
        for (int i = lastIdx; i >= 0; i--) {
            System.out.println(cap);
            if (cap <= 0) return;
            
            if (deliveries[i] < cap) {
                cap -= deliveries[i];
                deliveries[i] = 0;
            } else {
                deliveries[i] -= cap;
                return;
            }
        }
    }
    
    // return -> last index
    private int gatter(int[] deliveries, int[] pickups, int lastIdx, int cap) {
        int last = lastIdx;
        
        for (int i = lastIdx; i >= 0; i--) {
            if (pickups[i] <= cap) {
                cap -= pickups[i];
                pickups[i] = 0;
                
                if (deliveries[i] <= 0) last = i - 1;
            } else {
                pickups[i] -= cap;
                break;
            }
        }
        
        return last;
    }
}