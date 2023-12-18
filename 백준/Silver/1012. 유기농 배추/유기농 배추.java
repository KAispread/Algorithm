import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] moving = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        count++;
                        BFS(map, j, i);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void BFS(int[][] map, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        map[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[1];
            int cy = current[0];

            for (int[] move : moving) {
                int tx = cx + move[0];
                int ty = cy + move[1];

                if (validate(map, tx, ty)) {
                    queue.offer(new int[] {ty, tx});
                    map[ty][tx] = 0;
                }
            }
        }
    }

    private static boolean validate(int[][] map, int x, int y) {
        if (x < 0 || y < 0 || y >= map.length || x >= map[0].length) return false;
        if (map[y][x] == 0) return false;
        return true;
    }
}

