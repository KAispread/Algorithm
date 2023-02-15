package Do_it_Algorithm.DP;

import java.util.Scanner;

/*
* 11726번 - 2*N 타일 채우기
* */
public class Q87DP {
    static Tile[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new Tile[N + 1];

        dp[1] = new Tile(0, 1);

        for (int i = 2; i <= N; i++) {
            dp[i] = new Tile(dp[i - 1]);
        }
        Tile answer = dp[N];
        System.out.println((answer.height + answer.width) % Tile.MOD);
    }

    static class Tile {
        long width;
        long height;
        static final long MOD = 10007;

        public Tile(long width, long height) {
            this.width = width;
            this.height = height;
        }

        //
        public Tile(Tile t) {
            this.width = t.height % MOD;
            this.height = (t.width + t.height) % MOD;
        }
    }
}
