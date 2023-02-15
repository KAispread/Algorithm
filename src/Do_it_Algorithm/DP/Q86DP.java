package Do_it_Algorithm.DP;

import java.util.Scanner;

/*
* 2193번 - 이친수 구하기
* */
public class Q86DP {
    static Prinary[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Prinary[N + 1];

        // 첫 번째의 경우 1로 시작
        dp[1] = new Prinary(0, 1);

        for (int i = 2; i <= N; i++) {
            dp[i] = new Prinary(dp[i - 1]);
        }

        Prinary answer = dp[N];
        System.out.println(answer.one + answer.zero);
    }

    static class Prinary {
        int zero;
        int one;

        public Prinary(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        // N 자리수의 이친수 개수는 N-1 자리수의 이친수 개수로 구할 수 있음
        public Prinary(Prinary p) {
            this.one = p.zero;
            this.zero = p.zero + p.one;
        }
    }
}
