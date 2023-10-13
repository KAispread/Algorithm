import java.util.*;

class Solution {
    private int[][] moving = new int[][] {{1, 0}, {0, 1}};
    private int M;
    private int N;
    private int min;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        
        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        map[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1) {
                    if (i >= 1 && map[i - 1][j] != -1) {
                        map[i][j] += map[i - 1][j];
                    }
                    if (j >= 1 && map[i][j - 1] != -1) {
                        map[i][j] += map[i][j - 1];
                    }
                    if (map[i][j] > 1000000007) {
                        map[i][j] %= 1000000007;
                    }
                }
            }
        }
        answer = map[n-1][m-1];
        return answer;
    }
    
    private int getMinRoute(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            if (cx == M - 1 && cy == N - 1) continue;
            
            int forward = 0;
            for (int[] m : moving) {
                int x = cx + m[0];
                int y = cy + m[1];
                
                if (validate(map, x, y)) {
                    queue.offer(new int[] {x, y});
                    forward++;
                }
            }
            
            if (forward == 0) answer--;
            else if (forward == 2) answer++;
            
            if (answer > 1000000007) answer %= 1000000007;
        }
        
        return answer + 1;
    }
    
    private boolean validate(int[][] map, int x, int y) {
        if (x >= M || y >= N || map[x][y] < 0) return false;
        return true;
    }
}