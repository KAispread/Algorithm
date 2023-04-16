package Baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

/*
* 회장 뽑기 -
* */
public class Q2660 {
    static final int INF = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1) {
                break;
            }

            arr[x][y] = arr[y][x] = 1;
        }
        floyd(N, arr);

        int readerScore = INF;
        int[] scoreArr = new int[N + 1];
        readerScore = getScore(N, arr, readerScore, scoreArr);

        StringBuilder title = new StringBuilder();
        title.append(readerScore + " ");

        int readerNum = 0;

        StringBuilder body = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (readerScore == scoreArr[i]) {
                readerNum++;
                body.append(i + " ");
            }
        }

        title.append(readerNum + "\n");

        bw.write(title.toString());
        bw.write(body.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getScore(int N, int[][] arr, int readerScore, int[] scoreArr) {
        for (int i = 1; i <= N; i++) {
            int score = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF) {
                    score = Math.max(score, arr[i][j]);
                }
            }

            scoreArr[i] = score;
            readerScore = Math.min(readerScore, score);
        }
        return readerScore;
    }

    private static void floyd(int N, int[][] arr) {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
    }
}
