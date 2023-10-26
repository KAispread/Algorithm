import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* BFS
* int[][] 배열에 토마토를 저장
* int[i][j] 배열에 저장된 수 N은 i j 위치에 있는 토마토가 N일만에 익었다는 뜻
* 0이면 익지 않은 토마토
*
* 1. int[][] 배열을 순회하며 익은 토마토를 체크
* 2. 익은 토마토를 전부 Queue에 밀어넣음
*   Queue 를 순회하며 update 를 체크하고 업데이트한다면 Queue 에 다시 밀어넣음
* 2.1 이미 저장된 토마토가 0보다 크고
* 4. 주변에 익은 토마토가 없다면 while 문을 위한 boolean 변수에 true 할당
* ** 순회하는 동안에 가장 큰 일수를 저장
* */
public class Main {
    // 위, 아래, 상, 하, 좌, 우
    private static int[][] move = new int[][] {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    private static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j][k] = num;

                    if (num == 1) queue.add(new int[] {i,j,k});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentH = poll[0];
            int currentN = poll[1];
            int currentM = poll[2];

            int update = map[currentH][currentN][currentM] + 1;

            for (int[] mv : move) {
                int moveH = currentH + mv[0];
                int moveN = currentN + mv[1];
                int moveM = currentM + mv[2];

                if (isUpdatable(moveH, moveN, moveM, update)) {
                    queue.add(new int[] {moveH, moveN, moveM});
                }
            }
        }

        int answer = 0;
        boolean flag = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int current = map[i][j][k];
                    if (current == 0) {
                        flag = true;
                        break;
                    }
                    answer = Math.max(answer, current);
                }
            }
        }
        
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(answer - 1);
        }
    }

    private static boolean isUpdatable(int h, int n, int m, int update) {
        if (h < 0 || n < 0 || m < 0 || h >= map.length || n >= map[0].length || m >= map[0][0].length) return false;
        if (map[h][n][m] <= -1) return false;
        if (map[h][n][m] > 0) {
            map[h][n][m] = Math.min(map[h][n][m], update);
            return false;
        }
        map[h][n][m] = update;
        return true;
    }
}
