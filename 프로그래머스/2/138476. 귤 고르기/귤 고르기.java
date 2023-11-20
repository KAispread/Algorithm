import java.util.*;

class Solution {
    Map<Integer, Integer> weightMap;
    
    public int solution(int k, int[] tangerine) {
        weightMap = new HashMap<>();
        Queue<Weight> queue = new PriorityQueue<>((w1, w2) -> {
                return w2.count - w1.count;
        });

        for (int t : tangerine) {
            weightMap.put(t, weightMap.getOrDefault(t, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : weightMap.entrySet()) {
            queue.offer(new Weight(entry.getKey(), entry.getValue()));
        }
        
        int answer = 0;
        while (k > 0) {
            Weight w = queue.poll();
            k -= w.count;
            answer++;
        }
        
        return answer;
    }
    
    class Weight {
        int w;
        int count;
        
        public Weight(int w, int count) {
            this.w = w;
            this.count = count;
        }
    }
}