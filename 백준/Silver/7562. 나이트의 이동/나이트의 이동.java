import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] moving = new int[][] {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            int chessY = Integer.parseInt(st.nextToken());
            int chessX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            int targetY = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            boolean[][] visited = new boolean[N][N];

            int answer = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] {chessY, chessX, 0});
            visited[chessY][chessX] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (current[0] == targetY && current[1] == targetX) {
                    System.out.println(current[2]);
                    break;
                }

                for (int[] move : moving) {
                    int ty = current[0] + move[0];
                    int tx = current[1] + move[1];

                    if (validate(ty, tx, visited)) {
                        queue.offer(new int[] {ty, tx, current[2] + 1});
                        visited[ty][tx] = true;
                    }
                }
            }
        }
    }

    private static boolean validate(int y, int x, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= visited[0].length || y >= visited.length) return false;
        if (visited[y][x]) return false;
        return true;
    }
}
