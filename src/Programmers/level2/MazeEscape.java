package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
* 미로탈출
* */
public class MazeEscape {
    private int[][] moving = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int[][] map;
    private int N;
    private int M;

    private int[] start;
    private int[] lever;
    private int[] exit;

    public int solution(String[] maps) {
        setUp(maps);

        int L = BFS(start, lever);
        int E = BFS(lever, exit);

        if (L == -1 || E == -1) {
            return -1;
        }

        return L + E;
    }

    private int BFS(int[] S, int[] T) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {S[0], S[1], 0});
        visited[S[0]][S[1]] = true;

        int answer = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            if (T[0] == cx && T[1] == cy) {
                answer = current[2];
                break;
            }

            for (int[] M : moving) {
                int x = cx + M[0];
                int y = cy + M[1];

                if (validate(x, y, visited)) {
                    queue.offer(new int[] {x, y, current[2] + 1});
                    visited[x][y] = true;
                }
            }
        }

        return answer;
    }

    private boolean validate(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= N || y >= M ) return false;
        if (visited[x][y]) return false;
        if (map[x][y] == 0) return false;
        return true;
    }

    private void setUp(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];

        for (int i = 0; i < maps.length; i++) {
            String m = maps[i];
            for (int j = 0; j < m.length(); j++) {
                char mc = m.charAt(j);

                if (mc == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;

                    if (mc == 'S') start = new int[] {i, j};
                    if (mc == 'L') lever = new int[] {i, j};
                    if (mc == 'E') exit = new int[] {i, j};
                }
            }
        }
    }
}
