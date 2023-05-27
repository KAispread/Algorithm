package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 14503 - 로봇 청소기 - 골드 V
* */
public class Q14503 {
    static int direction = 0;
    static int[][] move = new int[][]{{0, -1},  {1, 0}, {0, 1}, {-1, 0}};
    static int[][] map;
    static int N = 0;
    static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 최대 좌표
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        map = new int[Y][X];

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        // map
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < X; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처음 있는 칸은 무조건 청소
        map[N][M] = 2;
        int answer = 1;

        while(true) {
            if (!check(X, Y)) {
                int mx = move[direction][0] * -1 + M;
                int my = move[direction][1] * -1 + N;

                if (mx >= 0 && my >= 0 && mx < X && my < Y) {
                    if (map[mx][my] == 1) break;

                    N = my;
                    M = mx;

                } else {
                    break;
                }

            } else {
                answer++;
            }

            System.out.println(answer);
        }

        System.out.println(answer);
    }

    private static boolean check(int maxX, int maxY) {
        int cd = direction;

        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                if (cd == 0) cd = 3;
                else cd--;
            }

            int X = M + move[cd][0];
            int Y = N + move[cd][1];

            if (X >= 0 && X < maxX && Y >= 0 && Y < maxY) {
                if (map[Y][X] < 1) {
                    direction = cd;
                    N = Y;
                    M = X;

                    // 청소한 칸은 2로
                    map[N][M] = 2;
                    return true;
                }
            }
        }

        return false;
    }

    private static void back() {
        // 후진
    }
}
