package commuLearning.week3.step2;

import java.util.LinkedList;
import java.util.Queue;

public class Question1 {
    private final int[] mx = new int[] {0, 0, -1, 1};
    private final int[] my = new int[] {1, -1, 0, 0};

    public int solution(int[][] maps) {
        return BFS(maps);
    }

    private int BFS(int[][] maps) {
        final int M = maps[0].length; // X
        final int N = maps.length;    // Y

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});

        boolean flag = false;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < mx.length; i++) {
                int x = now[0] + mx[i];
                int y = now[1] + my[i];

                if (x >= 0 && x < N &&
                        y >= 0 && y < M) {

                    if (maps[x][y] != 0 && !visited[x][y]) {
                        queue.offer(new int[] {x, y});
                        visited[x][y] = true;
                        maps[x][y] = maps[now[0]][now[1]] + 1;

                        if (x == N - 1 && y == M - 1) {
                            flag = true;
                        }
                    }
                }
            }
        }
        if (!flag) return -1;
        return maps[N - 1][M - 1];
    }
}
