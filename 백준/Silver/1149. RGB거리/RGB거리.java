import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* --> DP 로 풀자
* dp[i][j] = i = N 번째 집 / j = 0,1,2 (빨강, 파랑, 초록) 로 끝나는 집일 때 최소 값
* dp[1][0], dp[1][1], dp[1][2] 각각 첫 번째 집의 빨강, 파랑, 초록으로 끝나는 최소 값 데이터를 채움
* 2번째 집부터 시작
* dp[2][0] = 2번째 집인데 빨강으로 끝나는 최소 경우의 수 = dp[2][1] | dp[2][2] 중에 최소 값을 가지는 수
* ~ 반복
* return ==> dp[N][0] dp[N][1] dp[N][2] 중에 최소 값
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int houseCount = Integer.parseInt(st.nextToken());

        int[][] dp = new int[houseCount + 1][3];

        for (int i = 1; i <= houseCount; i++) {
            String[] amount = bf.readLine().split(" ");
            int r = Integer.parseInt(amount[0]);
            int g = Integer.parseInt(amount[1]);
            int b = Integer.parseInt(amount[2]);

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
        }

        System.out.println(Math.min(dp[houseCount][0], Math.min(dp[houseCount][1], dp[houseCount][2])));
    }

}
