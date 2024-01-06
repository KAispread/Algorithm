import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[][] moving = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // map 의 모든 정점에서 시작해서 상,하,좌,우 중 가장 최대인 수를 찾고 그 지점으로 이동, 4회까지만 반복 -> 최댓값 갱신
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startX = 0;
        int startY = 0;

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number == 2) {
                    startY = i;
                    startX = j;
                } else if (number == 1) {
                    map[i][j] = -1;
                }
            }
        }

        markMap(startX, startY);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void markMap(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY, 0});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] move : moving) {
                int x = current[0] + move[0];
                int y = current[1] + move[1];

                if (validate(x, y)) {
                    visited[y][x] = true;
                    queue.offer(new int[] {x, y, current[2] + 1});
                    map[y][x] = current[2] + 1;
                }
            }
        }
    }

    private static boolean validate(int x, int y) {
        if (x < 0 || y < 0 || y >= map.length || x >= map[0].length) return false;
        if (map[y][x] == 0) return false;
        if (visited[y][x]) return false;
        return true;
    }
}

