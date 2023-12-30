import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int X;
    static int Y;
    static int[][] map;
    static int[][] moving = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        map = new int[Y][X];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < X; j++) {
                int current = Integer.parseInt(st.nextToken());
                map[i][j] = current;

                if (current == 1) queue.offer(new int[] {i, j});
            }
        }

        System.out.println(BFS(queue));
    }

    private static int BFS(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];

            for (int[] move : moving) {
                int ty = cy + move[0];
                int tx = cx + move[1];

                if (isUpdatable(tx, ty)) {
                    map[ty][tx] = map[cy][cx] + 1;
                    queue.offer(new int[] {ty, tx});
                }
            }
        }

        return getDay();
    }

    private static int getDay() {
        int answer = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) return -1;

                answer = Math.max(answer, map[i][j]);
            }
        }

        return answer - 1;
    }

    private static boolean isUpdatable(int x, int y) {
        if (x < 0 || y < 0 || x >= X || y >= Y) return false;
        if (map[y][x] > 0 || map[y][x] == -1) return false;
        return true;
    }
}

