import java.util.*;

/*
Land를 순회하며 석유 덩어리를 묶음 (BFS 사용)
- 석유 덩어리를 발견한다면 ID 값을 부여하고 Map<Integer, Integer> 에 값을 Update
- land 좌표에 ID 값을 넣어줌 

열만큼 반복
- 시추관의 위치에 따라 지나치는 석유 덩어리의 ID 값을 Set 에 저장
- Set에 담겨있는 석유의 가중치를 가져옴
*/

class Solution {
    
    private Map<Integer, Integer> proofMap = new HashMap<>();
    private int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int solution(int[][] land) {        
        // land를 순회하며 석유 덩어리를 찾고 ID를 부여함
        markOil(land);
        
        // land[i][N] 의 N만큼 반복하며 최대로 석유를 추출할 수 있는 ID 값 Update
        int answer = getMaxOilAmount(land);
        
        return answer;
    }
    
    // 최대로 석유를 추출할 수 있는 지점을 가져옴
    private int getMaxOilAmount(int[][] land) {
        int max = 0;
        
        for (int i = 0; i < land[0].length; i++) {
            Set<Integer> oilSet = new HashSet<>();
            int amount = 0;
            
            for (int j = 0; j < land.length; j++) {
                oilSet.add(land[j][i]);
            }
            
            for (int oilId : oilSet) {
                if (oilId >= 2) amount += proofMap.get(oilId);
            }
            
            max = Math.max(max, amount);
        }
        
        return max;
    }
    
    // 석유 마킹
    private void markOil(int[][] land) {
        int oilId = 2;
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) BFS(land, i, j, oilId);
                oilId++;
            }
        }
    }
    
    private void BFS(int[][] land, int y, int x, int id) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {y, x});
        land[y][x] = id;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            
            proofMap.put(id, proofMap.getOrDefault(id, 0) + 1);
            
            for (int[] move : moving) {
                int ty = cy + move[0];
                int tx = cx + move[1];
                
                if (validateBFS(land, ty, tx)) {
                    land[ty][tx] = id;
                    queue.offer(new int[] {ty, tx});
                }
            }
        }
    }
    
    private boolean validateBFS(int[][] land, int y, int x) {
        if (y < 0 || x < 0 || y >= land.length || x >= land[0].length) return false;
        if (land[y][x] != 1) return false;
        return true;
    }

}