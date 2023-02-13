package Do_it_Algorithm.DP;

import java.util.Scanner;

/*
* 14501번 - 퇴사 준비하기
* 큰 문제 - N 일까지 상담이 가능할 때 최대 이익을 낼 수 있는 경우
* 작은 문제 - 1일 부터 N 일까지 Bottom Up 방식으로 최대 이익을 구하면 됨
* */
public class Q85DP {
    static int[][] salary;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        salary = new int[N + 1][2];
        dp = new int[N + 2];

        for (int i = 1; i < salary.length; i++) {
            salary[i][0] = sc.nextInt();
            salary[i][1] = sc.nextInt();
        }

        for (int i = 1; i < salary.length; i++) {
            int dayAfter = salary[i][0] + i;
            int amount = salary[i][1];

            // 상담일이 유효하지 않을 경우 건너뜀
            if (dayAfter > N + 1) continue;

            // 현재 날짜까지의 최댓값 + 가격을 -> 현재 날짜 + N일 후의 최댓값과 비교하여 최댓값 업데이트
            dp[dayAfter] = Math.max(dp[dayAfter], dp[i] + amount);

            // i + day 날 부터 마지막 날까지의 최댓값 업데이트
            for (int j = dayAfter + 1; j <= N + 1; j++) {
                dp[j] = Math.max(dp[j], dp[dayAfter]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}
