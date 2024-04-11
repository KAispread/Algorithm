import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // Stack의 size가 2보다 크면서 스택의 가장 위에 있는 문자가 현재 문자와 일치하지 않을 때 NO
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());

            // 현재 숫자보다 1 작은 값이 먼저 나왔다면 dp[current]는 2 이상이 될 것.
            dp[current] = dp[current - 1] + 1;
        }

        int max = 0;
        for (int count : dp) max = Math.max(max, count);
        System.out.println(N - max);
    }
}
