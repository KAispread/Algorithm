import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] moving = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N;

    // Blue 색깔은 미리 계산 후 0으로 초기화 -> 이후 배열 복사 -> 적록색약인 경우, 아닌 경우 따로 BFS Go
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[][] map2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();

            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                if (c == 'R') {
                    map[i][j] = 1;
                    map2[i][j] = 1;
                } else if (c == 'G') {
                    map[i][j] = 2;
                    map2[i][j] = 2;
                } else {
                    map[i][j] = 3;
                    map2[i][j] = 3;
                }
            }
        }

        int normalCount = calcAreaNormal(map);
        int specialCount = calcAreaSpecial(map2);
        System.out.println(normalCount + " " + specialCount);
    }

    private static int calcAreaNormal(int[][] map) {
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 3) {
                    count++;
                    BFS(map, i, j, 3);
                } else if (map[i][j] == 2) {
                    count++;
                    BFS(map, i, j, 2);
                } else if (map[i][j] == 1) {
                    count++;
                    BFS(map, i, j, 1);
                }
            }
        }

        return count;
    }

    private static int calcAreaSpecial(int[][] map) {
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 3) {
                    count++;
                    BFS(map, i, j, 3);
                } else if (map[i][j] == 2 || map[i][j] == 1) {
                    count++;
                    BFS(map, i, j, 1, 2);
                }
            }
        }

        return count;
    }

    private static void BFS(int[][] map, int y, int x, int... flag) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        map[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] move : moving) {
                int tx = current[0] + move[0];
                int ty = current[1] + move[1];

                if (validate(map, tx, ty, flag)) {
                    map[ty][tx] = 0;
                    queue.offer(new int[] {tx, ty});
                }
            }
        }
    }

    private static boolean validate(int[][] map, int x, int y, int... flag) {
        if (x < 0 || y < 0 || x >= N || y >= N) return false;
        for (int f : flag) {
            if (map[y][x] == f) return true;
        }

        return false;
    }
}

