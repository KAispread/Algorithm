package commuLearning.week4;

import java.util.LinkedList;
import java.util.Queue;

/*
* 세균 증식 - 정답
* */
public class Question1 {
    private int row;
    private int column;

    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        row = rows;
        column = columns;

        BFS(answer, queries, max_virus);

        return answer;
    }

    private void BFS(int[][] answer, int[][] queries, int max) {
        boolean[][] visited;
        Queue<int[]> queue = new LinkedList<>();
        int[][] moving = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < queries.length; i++) {
            int cx = queries[i][0] - 1;
            int cy = queries[i][1] - 1;

            queue.offer(new int[] {cx, cy});
            visited = new boolean[row][column];
            visited[cx][cy] = true;

            while(!queue.isEmpty()) {
                int[] target = queue.poll();
                int tx = target[0];
                int ty = target[1];

                if (answer[tx][ty] < max) {
                    answer[tx][ty]++;
                    continue;
                }

                if (answer[tx][ty] == max) {
                    for (int j = 0; j < moving.length; j++) {
                        int x = tx + moving[j][0];
                        int y = ty + moving[j][1];

                        if (isValid(visited, x, y)) {
                            visited[x][y] = true;
                            queue.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
    }

    private boolean isValid(boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= column) return false;
        if (visited[x][y]) return false;
        return true;
    }
}
