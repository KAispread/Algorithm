import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 다익스트라 알고리즘 사용
* */
public class Main {

    private static BufferedReader bf;
    private static StringTokenizer st;

    private static int[][] move = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] minimum;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;
        while (true) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            solution(N, cnt);
            cnt++;
        }
    }

    private static void solution(int N, int cnt) throws IOException {
        map = new int[N][N];
        visited = new boolean[N][N];
        minimum = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(minimum[i], 10_0000_0000);
        }


        Queue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.amount - o2.amount);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 목적지 map[N - 1][N - 1];
        queue.offer(new Node(0, 0, map[0][0]));
        minimum[0][0] = map[0][0];

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if (!visited[current.x][current.y]) {
                visited[current.x][current.y] = true;

                for (int[] m : move) {
                    int cx = current.x + m[0];
                    int cy = current.y + m[1];

                    if (ableToGo(cx, cy, N, current.amount)) {
                        minimum[cx][cy] = Math.min(minimum[cx][cy], current.amount + map[cx][cy]);
                        queue.offer(new Node(cx, cy, minimum[cx][cy]));
                    }
                }
            }
        }

        System.out.println("Problem "+cnt+": " + minimum[N-1][N-1]);
    }

    private static boolean ableToGo(int x, int y, int N, int currentAmount) {
        if (x < 0 || y < 0 || x >= N || y >= N) return false;
        if (visited[x][y]) return false;
        if (minimum[x][y] < currentAmount + map[x][y]) return false;
        return true;
    }

    static class Node {
        int x;
        int y;
        int amount;

        public Node(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }
}
