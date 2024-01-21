import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            numbers[i] = current;
        }

        Arrays.fill(dp, 1);

        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];

            for (int j = i - 1; j >= 0; j--) {
                if (current > numbers[j] && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
            }
        }

        int max = 0;
        for (int number : dp) {
            max = Math.max(number, max);
        }

        System.out.println(max);
    }
}

