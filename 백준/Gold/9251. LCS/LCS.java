import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String B = bf.readLine();
        String A = bf.readLine();

        int[][] dp = new int[A.length() + 1][B.length() + 1];

        int max = 0;
        for (int i = 1; i <= B.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {
                if (A.charAt(j - 1) == B.charAt(i - 1)) {
                    dp[j][i] = dp[j-1][i-1] + 1;
                } else {
                    dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
                }
                max = Math.max(max, dp[j][i]);
            }
        }

        System.out.println(max);
    }
}

