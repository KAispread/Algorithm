import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int cheese;
    static int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    // 외부 공기를 마킹해주면 됨
    // 1. BFS로 외부 공기를 2로 마킹해줌
    // 2. 전체 맵을 순회하며 치즈를 만났을 때, 상하좌우에서 외부공기가 2번 이상 맞닿아있다면 0으로 초기화
    // 3. 다음 사이클 시작
    // 4. 외부 공기 마킹 [반복]
    // 전체 치즈의 개수를 저장해놓고 치즈의 개수가 0이 될 때까지 반복
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;

                if (number == 1) cheese++;
            }
        }

        int day = 0;
        while (cheese > 0) {
            day++;
            markFreshAir();
            removeCheese();
        }

        System.out.println(day);
    }

    private static void markFreshAir() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[0][0] = true;
        map[0][0] = 2;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] move : moving) {
                int tx = current[0] + move[0];
                int ty = current[1] + move[1];

                if (validate(tx, ty, visited)) {
                    visited[ty][tx] = true;
                    queue.offer(new int[] {tx, ty});
                    map[ty][tx] = 2;
                }
            }
        }
    }

    private static boolean validate(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || y >= map.length || x >= map[0].length) return false;
        if (visited[y][x]) return false;
        if (map[y][x] == 1) return false;
        return true;
    }

    private static void removeCheese() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 1) continue;
                int freshAir = 0;

                for (int[] move : moving) {
                    int tx = move[0] + j;
                    int ty = move[1] + i;

                    if (tx < 0 || ty < 0 || ty >= map.length || tx >= map[0].length) continue;
                    if (map[ty][tx] == 2) freshAir++;
                }

                if (freshAir >= 2) {
                    map[i][j] = 0;
                    cheese--;
                }
            }
        }
    }
}

