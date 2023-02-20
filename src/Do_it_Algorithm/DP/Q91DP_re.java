package Do_it_Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 1915번 - 재시도
* */
public class Q91DP_re {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bf.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        int[][] tile = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String num = bf.readLine();
            for (int j = 1; j <= M; j++) {
                tile[i][j] = num.charAt(j - 1) - '0';
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (tile[i][j] == 1) {
                    tile[i][j] = Math.min(tile[i - 1][j - 1], Math.min(tile[i - 1][j], tile[i][j - 1])) + 1;
                    answer = Math.max(answer, tile[i][j]);
                }
            }
        }

        System.out.println(answer * answer);
    }
}
