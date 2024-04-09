import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int max = 0;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    max = Math.max(BFS(i, j, visited), max);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    private static int BFS(int y, int x, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {y, x});
        visited[y][x] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] move : moving) {
                int ty = current[0] + move[0];
                int tx = current[1] + move[1];

                if (validate(tx, ty, visited)) {
                    queue.offer(new int[] {ty, tx});
                    visited[ty][tx] = true;
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean validate(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= visited[0].length || y >= visited.length) return false;
        if (visited[y][x]) return false;
        if (map[y][x] == 0) return false;
        return true;
    }
}
