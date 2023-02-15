package Do_it_Algorithm.DP;

import java.util.Scanner;

/*
* 10844번 - 계단 수 구하기
* */
public class Q88DP {
    static long[][] stair;
    static final long MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        stair = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            stair[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    stair[i][1] = stair[i-1][0];
                    continue;
                } else if (j == 9) {
                    stair[i][8] = (stair[i][8] + stair[i-1][9]) % MOD;
                    continue;
                }

                stair[i][j - 1] = (stair[i][j - 1] + stair[i - 1][j]) % MOD;
                stair[i][j + 1] = (stair[i][j + 1] + stair[i - 1][j]) % MOD;
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + stair[N][i]) % MOD;
        }
        System.out.println(answer);
    }
}
