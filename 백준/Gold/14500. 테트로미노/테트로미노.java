import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_POINT_LENGTH = 4;
    static boolean[][] visited;
    static int[][] map;
    static int[][] moving = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer = 0;

    // map 의 모든 정점에서 시작해서 상,하,좌,우 중 가장 최대인 수를 찾고 그 지점으로 이동, 4회까지만 반복 -> 최댓값 갱신
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                search(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void search(int y, int x, int depth, int sum) {
        if (depth == MAX_POINT_LENGTH) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int[] move : moving) {
            int tx = x + move[0];
            int ty = y + move[1];

            if (isAbleToGo(ty, tx)) {
                visited[ty][tx] = true;
                search(ty, tx, depth + 1, sum + map[ty][tx]);
                visited[ty][tx] = false;

                if (depth == 2) {
                    visited[ty][tx] = true;
                    search(y, x, depth + 1, sum + map[ty][tx]);
                    visited[ty][tx] = false;
                }
            }
        }
    }

    private static boolean isAbleToGo(int y, int x) {
        if (y < 0 || x < 0 || x >= map[0].length || y >= map.length) return false;
        if (visited[y][x]) return false;
        return true;
    }
}

