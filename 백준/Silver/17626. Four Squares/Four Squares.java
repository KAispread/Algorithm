import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // map 의 모든 정점에서 시작해서 상,하,좌,우 중 가장 최대인 수를 찾고 그 지점으로 이동, 4회까지만 반복 -> 최댓값 갱신
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int number = Integer.parseInt(st.nextToken());
        int[] dp = new int[number + 1];

        dp[1] = 1;

        for (int i = 2; i <= number; i++) {
            int min = Integer.MAX_VALUE;

            // j^2 + 가장 작은 수를 보유한 수를 하면 i를 가장 작은 숫자로 만들 수 있음
            // 1 + min
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }

        System.out.println(dp[number]);
    }

}

