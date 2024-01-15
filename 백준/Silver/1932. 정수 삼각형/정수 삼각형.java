import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // Bottom-Up 방식
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[][] dp = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= i; j++) {
                int number = Integer.parseInt(st.nextToken());
                dp[i][j] = number;
            }
        }

        for (int i = size - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + dp[i][j];
            }
        }

        System.out.println(dp[1][1]);
    }
}

