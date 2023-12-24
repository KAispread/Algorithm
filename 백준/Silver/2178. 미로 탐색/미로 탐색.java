import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int Y;
    private static int X;
    private static int[][] moving = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int[][] map = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            char[] line = bf.readLine().toCharArray();

            for (int j = 0; j < line.length; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        int answer = getShortestWay(map);
        System.out.println(answer);
    }

    private static int getShortestWay(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1});
        boolean[][] visited = new boolean[Y][X];
        visited[0][0] = true;

        int answer = 100_000;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (X - 1 == current[0] && Y - 1 == current[1]) {
                answer = Math.min(current[2], answer);
                continue;
            }

            for (int[] move : moving) {
                int cx = current[0] + move[0];
                int cy = current[1] + move[1];

                if (validate(map, visited, cx, cy)) {
                    visited[cy][cx] = true;
                    queue.offer(new int[] {cx, cy, current[2] + 1});
                }
            }
        }

        return answer;
    }

    private static boolean validate(int[][] map, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= X || y >= Y) return false;
        if (map[y][x] < 1) return false;
        if (visited[y][x]) return false;
        return true;
    }
}

