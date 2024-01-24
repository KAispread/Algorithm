import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // knapsack Algorithm
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            w[i] = weight;
            v[i] = value;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] =  dp[i-1][j];
                int remain = j - w[i];

                if (remain >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][remain] + v[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }

}

