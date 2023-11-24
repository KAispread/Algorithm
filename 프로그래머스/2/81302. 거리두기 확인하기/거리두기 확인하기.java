import java.util.*;
/*
2칸 이상 차이나도록 앉아라
근데 파티션으로 막혀있을 땐 가능
-> 맵 찾아가기 BFS

int[] next = next[0], next[1] == x, y && next[2] == 기준점으로부터의 거리
각 대기실 별로 맵을 순회하며 응시자가 있다면 BFS 탐색 시작
BFS
현재 지점으로부터 상,하,좌,우를 탐색
갈 수 있는 지점 (맵이 있음, 파티션이 아님 이라면) 현재 지점 +1 하여 지점 좌표값과 함께 Queue에 저장
queue에서 원소를 꺼냈을 때 거리가 3이상이라면 continue
*/
class Solution {
    
    private int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            char[][] map = new char[places.length][places[0].length];
            
            for (int m = 0; m < places[0].length; m++) {
                map[m] = places[i][m].toCharArray();
            }
            
            if (isRightQueue(map)) {
                answer[i] = 1;   
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    // 각 대기실별로 거리두기 준수 여부를 구하는 메소드
    private boolean isRightQueue(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'P' && !BFS(map, i, j)) return false;
            }
        }
        
        return true;
    }
    
    // 응시자로부터 2까지 떨어져있는 곳까지 탐색하는 메서드
    // 거리두기 수칙을 잘 지켰다면 True, 아니라면 false
    private boolean BFS(char[][] map, int pivotX, int pivotY) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {pivotX, pivotY, 0});
        visited[pivotX][pivotY] = true;
        
        while(!queue.isEmpty()) {
            int[] polled = queue.poll();
            int cx = polled[0];
            int cy = polled[1];
            int clength = polled[2];
            
            if (clength >= 2) continue;
            
            for (int[] move : moving) {
                int nx = cx + move[0];
                int ny = cy + move[1];
                
                if (clength < 2 && isAbleToGo(map, visited, nx, ny)) {
                    if (map[nx][ny] == 'P') return false;
                    
                    queue.offer(new int[] {nx, ny, clength + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return true;
    }
    
    // 다음으로 갈 수 있는지 판단
    private boolean isAbleToGo(char[][] map, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x > 4 || y > 4) return false;
        if (visited[x][y]) return false;
        if (map[x][y] == 'X') return false;
        return true;
    }
}