package commuLearning.week4;

import java.util.LinkedList;
import java.util.Queue;

public class Retry1 {
    private int[][] node;
    private int row;
    private int column;

    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        node = new int[rows][columns];
        row = rows;
        column = columns;

        BFS(queries, max_virus);

        return node;
    }

    private void BFS(int[][] queries, int max) {
        boolean[][] visited;
        int[][] moving = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < queries.length; i++) {
            int cx = queries[i][0] - 1;
            int cy = queries[i][1] - 1;

            queue.offer(new int[] {cx, cy});
            visited = new boolean[row][column];
            visited[cx][cy] = true;

            while (!queue.isEmpty()) {
                int[] target = queue.poll();
                int tx = target[0];
                int ty = target[1];

                if (node[tx][ty] < max) {
                    node[tx][ty]++;
                    continue;
                }

                for (int j = 0; j < moving.length; j++) {
                    int x = tx + moving[j][0];
                    int y = ty + moving[j][1];

                    if (isValid(x, y, visited)) {
                        queue.offer(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= row || y >= column) return false;
        if (visited[x][y]) return false;
        return true;
    }
}
