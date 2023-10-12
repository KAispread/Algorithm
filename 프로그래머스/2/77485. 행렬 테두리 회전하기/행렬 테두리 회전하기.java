import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        
        // map 생성
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                cnt++;
                map[i][j] = cnt;
            }
        }
        
        int[] answer = new int[queries.length];
        int answerIdx = 0;
        for (int[] querie : queries) {
            //System.out.println("---- new loop ----");
            int x1 = querie[0] - 1;
            int y1 = querie[1] - 1;
            int x2 = querie[2] - 1;
            int y2 = querie[3] - 1;
            
            int min = Integer.MAX_VALUE;
            int start = map[x1][y1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            min = Math.min(min, start);
            
            // y축 오른쪽
            for (int i = y1 + 1; i <= y2; i++) {
                int current = map[x1][i];
                map[x1][i] = queue.poll();
                queue.offer(current);
                min = Math.min(min, current);
                
                //System.out.println("x: " + x1 + " | y:" + i + " :: before : " + current + 
                                   //" / after : " + map[x1][i]);
            }
            
            // x축 아래
            for (int i = x1 + 1; i <= x2; i++) {
                int current = map[i][y2];
                map[i][y2] = queue.poll();
                queue.offer(current);
                min = Math.min(min, current);
                
                //System.out.println("x: " + i + " | y:" + y2 + " :: before : " + current + 
                                  // " / after : " + map[i][y2]);
            }
            
            // y축 왼쪽
            for (int i = y2 - 1; i >= y1; i--) {
                int current = map[x2][i];
                map[x2][i] = queue.poll();
                queue.offer(current);
                min = Math.min(min, current);
                
                //System.out.println("x: " + x2 + " | y:" + i + " :: before : " + current + 
                                   //" / after : " + map[x2][i]);
            }
            
            // x축 위
            for (int i = x2 - 1; i >= x1; i--) {
                int current = map[i][y1];
                map[i][y1] = queue.poll();
                queue.offer(current);
                min = Math.min(min, current);
            }
            
            answer[answerIdx] = min;
            answerIdx++;
        }
        
        return answer;
    }
}