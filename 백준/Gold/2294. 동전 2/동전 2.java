import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dp = new int[100001];

        for (int i = 0; i < N; i++) {
            int current = sc.nextInt();
            dp[current] = 1;
        }

        for (int i = 2; i <= K; i++) {
            int pivot = i / 2;

            for (int p = pivot; p > 0; p--) {
                int o = i - p;

                if (o < 0 || o > K || p < 0 || p > K) continue;

                if (dp[o] != 0 && dp[p] != 0 ) {
                    int go = dp[o] + dp[p];

                    if (dp[i] != 0) {
                        dp[i] = Math.min(dp[i], go);
                    } else {
                        dp[i] = go;
                    }
                }
            }
        }

        if (dp[K] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[K]);
    }

}
