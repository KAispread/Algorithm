package Programmers.level2;

import java.util.*;

/*
* 무인도
* */
public class UninhabitedIsland {
    private int[][] moving = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;
    private int[][] intMap;
    private int N;
    private int M;

    public int[] solution(String[] maps) {
        setUp(maps);
        final List<Integer> island = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (intMap[i][j] > 0 && !visited[i][j]) BFS(island, i, j);
            }
        }

        if (island.isEmpty()) return new int[] {-1};

        Collections.sort(island);
        int[] answer = new int[island.size()];

        for (int day = 0; day < answer.length; day++) {
            answer[day] = island.get(day);
        }

        return answer;
    }

    private void BFS(List<Integer> island, int x, int y) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] target = queue.poll();
            int tx = target[0];
            int ty = target[1];

            count += intMap[tx][ty];

            for (int[] m : moving) {
                int cx = tx + m[0];
                int cy = ty + m[1];

                if (validate(cx, cy)) {
                    queue.offer(new int[] {cx, cy});
                    visited[cx][cy] = true;
                }
            }
        }

        island.add(count);
    }

    private void setUp(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        intMap = new int[N][M];
        visited = new boolean[N][M];

        for (int m = 0; m < N; m++) {
            String row = maps[m];
            for (int i = 0 ; i < M; i++) {
                char c = row.charAt(i);
                if (c > '0' && c <= '9') {
                    intMap[m][i] = c - '0';
                } else {
                    intMap[m][i] = -1;
                }
            }
        }
    }

    private boolean validate(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) return false;
        if (intMap[x][y] <= 0) return false;
        if (visited[x][y]) return false;
        return true;
    }
}
