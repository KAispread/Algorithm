package Do_it_Algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 2178번 - Silver I
* 미로 문제
*
* 핵심 전략
*   - 이차원 배열에 0, 1을 저장하고 상,하,좌,우를 탐색하여 갈 수 있는 곳의 좌표를 Queue 에 삽입
*   - 경로의 깊이를 저장하는 이차원 배열에 (갈 수 있는 곳의 좌표 = 현재 좌표값 깊이 + 1) 연산으로 깊이를 저장
*   - BFS 탐색이 끝나고 목표로 하는 지점의 경로의 깊이를 출력
* */
public class Q27BFS {
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};
    static int N;
    static int M;
    static int[][] depth;
    static int[][] route;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        depth = new int[N][M];
        route = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String[] row = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                route[i][j] = Integer.parseInt(row[j]);
            }
        }

        BFS(0, 0);
        System.out.println(depth[N -1][M - 1]);
    }

    private static void BFS(int initX, int initY) {
        Queue<int[]> BFSQueue = new LinkedList<>();
        BFSQueue.add(new int[] {initX, initY});
        depth[initX][initY] = 1;

        while (!BFSQueue.isEmpty()) {
            int[] poll = BFSQueue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < moveX.length; i++) {
                int forwardX = x + moveX[i];
                int forwardY = y + moveY[i];
                if (forwardX >= 0 && forwardX < N && forwardY >= 0 && forwardY < M) {
                    if (route[forwardX][forwardY] == 1 && depth[forwardX][forwardY] == 0) {
                        BFSQueue.add(new int[] {forwardX, forwardY});
                        depth[forwardX][forwardY] = depth[x][y] + 1;
                    }
                }
            }
        }
    }
}
