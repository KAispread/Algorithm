import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int totalSafeArea;
    static int maxSafeArea = 0;
    static int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        totalSafeArea = N * M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;

                if (number > 0) totalSafeArea--;
            }
        }

        setMaxSafeArea();
        System.out.println(maxSafeArea);
    }

    private static void setMaxSafeArea() {
        // 가벽을 세움
        setWallInMap(0, 0, 0);
    }

    // 가벽을 세움 3개
    private static void setWallInMap(int wallCount, int y, int x) {
        if (wallCount == 3) {
            updateSafeArea(copyOf(map));
            return;
        }

        int X = x;
        int Y = y;
        if (X >= map[0].length) {
            X = 0;
            Y += 1;
        }

        if (X >= map[0].length || Y >= map.length) return;

        for (int i = Y; i < map.length; i++) {
            int jj = 0;
            if (i == Y) jj = X;

            for (int j = jj; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    setWallInMap(wallCount + 1, i, j + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int[][] copyOf(int[][] map) {
        int[][] newMap = new int[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            newMap[i] = Arrays.copyOf(map[i], map[i].length);
        }
        return newMap;
    }

    // 안전 영역을 구하고 최소값 update
    private static void updateSafeArea(int[][] wallInMap) {
        int effectedArea = 3;
        boolean[][] visited = new boolean[wallInMap.length][wallInMap[0].length];

        for (int i = 0; i < wallInMap.length; i++) {
            for (int j = 0; j < wallInMap[0].length; j++) {
                if (wallInMap[i][j] == 2 && !visited[i][j]) {
                    effectedArea += runVirus(wallInMap, visited, i, j);
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, totalSafeArea - effectedArea);
    }

    private static int runVirus(int[][] wallInMap, boolean[][] visited, int y, int x) {
        int effectedCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] move : moving) {
                int tx = current[1] + move[0];
                int ty = current[0] + move[1];

                if (validate(wallInMap, visited, ty, tx)) {
                    effectedCount++;
                    queue.offer(new int[] {ty, tx});
                    wallInMap[ty][tx] = 2;
                    visited[ty][tx] = true;
                }
            }
        }

        return effectedCount;
    }

    private static boolean validate(int[][] wallInMap, boolean[][] visited, int y, int x) {
        if (x < 0 || y < 0 || x >= wallInMap[0].length || y >= wallInMap.length) return false;
        if (wallInMap[y][x] == 2 || wallInMap[y][x] == 1) {
            return false;
        }
        return true;
    }
}

