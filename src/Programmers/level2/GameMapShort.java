package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
* 게임 맵 최단거리
* */
public class GameMapShort {
    private int[][] moving = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private boolean visited[][];
    private int N;
    private int M;

    public int solution(int[][] maps) {
        N = maps.length - 1;
        M = maps[0].length - 1;
        visited = new boolean[N + 1][M + 1];

        return BFS(maps);
    }

    private int BFS(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        boolean finish = false;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int cx = p[0];
            int cy = p[1];

            for (int[] m : moving) {
                int x = cx + m[0];
                int y = cy + m[1];

                if (validate(x, y, maps)) {
                    visited[x][y] = true;
                    maps[x][y] = maps[cx][cy] + 1;
                    queue.offer(new int[] {x, y});
                }

                if (x == N && y == M) finish = true;
            }
        }

        if (finish) return maps[N][M];
        return -1;
    }

    private boolean validate(int x, int y, int[][] maps) {
        if (x < 0 || y < 0 || x > N || y > M) return false;
        if (visited[x][y]) return false;
        if (maps[x][y] == 0) return false;
        return true;
    }
}
