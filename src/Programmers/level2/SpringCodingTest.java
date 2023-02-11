package Programmers.level2;
import java.util.*;

public class SpringCodingTest {

    class Solution {
        int[][] movA = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] movS = {{-1,-1}, {1,-1}, {1,1}, {-1,1}};
        boolean[][] visited;
        int[][] tile;

        public int solution(String[] grid) {
            tile = new int[grid.length][grid[0].length()];
            visited = new boolean[grid.length][grid[0].length()];
            int row = 0;

            // Update tile
            for (String g : grid) {
                for (int i = 0; i < g.length(); i++) {
                    if (g.charAt(i) == '#') {
                        tile[row][i] = 1;
                    } else {
                        tile[row][i] = 0;
                    }
                }
                row++;
            }

            int answer = 0;
            for (int i = 0; i < tile.length; i++) {
                for (int j = 0; j < tile[0].length; j++) {
                    if (!visited[i][j] && tile[i][j] == 1) {
                        answer += BFS(i, j);
                    }
                }
            }

            return answer;
        }

        private int BFS(int y, int x) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {y, x});
            visited[y][x] = true;

            int count = 0;
            while (queue.isEmpty()) {
                int[] target = queue.poll();
                count++;
                int cx = target[1];
                int cy = target[0];

                // side search
                for (int[] s : movS) {
                    int ty = cy - s[0];
                    int tx = cx - s[1];

                    if (isValid(ty, tx) && tile[ty][tx] == 1) {
                        visited[ty][tx] = true;
                        queue.offer(new int[] {ty, tx});
                    }
                }

                // forward search
                for (int[] a : movA) {
                    int ty = cy - a[0];
                    int tx = cx - a[1];

                    if (isValid(ty, tx) && tile[ty][tx] == 1) {
                        visited[ty][tx] = true;
                        queue.offer(new int[] {ty, tx});
                    }
                }
            }

            return count;
        }

        private int checkDot(int y, int x) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {y, x});
            visited[y][x] = true;

            boolean flag = true;
            int count = 0;
            while (queue.isEmpty() && flag) {
                int[] target = queue.poll();
                count++;
            }

            if (flag) {
                return count;
            }
            return 0;
        }

        private boolean isValid(int y, int x) {
            if (x < 0 || y < 0 || y >= tile.length || x >= tile[0].length) return false;
            if (visited[y][x]) return false;
            return true;
        }
    }
}
