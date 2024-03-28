import java.util.*;

class Solution {
    private int[] union;
    
    public int solution(int n, int[][] costs) {
        union = new int[n];
        
        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }
        
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            int island1 = costs[i][0];
            int island2 = costs[i][1];
            
            if (find(island1) != find(island2)) {
                union(island1, island2);
                count += costs[i][2];
                
                if (isAllConnect()) break;
            }
        }
        
        return count;
    }
    
    private void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        
        if (A != B) union[B] = A;
    }
    
    private int find(int a) {
        if (union[a] == a) return a;
        return union[a] = find(union[a]);
    }
    
    private boolean isAllConnect() {
        int f = find(0);
        for (int i = 1; i < union.length; i++) {
            if (find(i) != f) return false;
        }
        return true;
    }
}