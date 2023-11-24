import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        final long MAX_COUNT = (queue1.length + queue2.length) * 2;
        long sum = 0;
        int answer = 0;
        
        Queue<Integer> linked1 = new LinkedList<>();
        Queue<Integer> linked2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            sum += queue1[i] + queue2[i];
            linked1.offer(queue1[i]);
            linked2.offer(queue2[i]);
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        long pivot = sum / 2;
        if (sum % 2 != 0) return -1;
        
        while (answer <= MAX_COUNT) {
            if (sum1 == pivot) return answer;
            
            if (sum1 > sum2) {
                int polled = linked1.poll();
                linked2.offer(polled);
                
                sum1 -= polled;
                sum2 += polled;
            } else {
                int polled = linked2.poll();
                linked1.offer(polled);
                
                sum1 += polled;
                sum2 -= polled;
            }
            answer++;
        }
        
        return -1;
    }
}
