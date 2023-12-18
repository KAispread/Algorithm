import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static class Fibo {
        int number;
        int zeroCount;
        int oneCount;

        public Fibo(int number, Fibo beforeTwo, Fibo beforeOne) {
            this.number = number;
            this.zeroCount = beforeTwo.zeroCount + beforeOne.zeroCount;
            this.oneCount = beforeTwo.oneCount + beforeOne.oneCount;
        }

        public Fibo(int number, int zeroCount, int oneCount) {
            this.number = number;
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Fibo[] dp = new Fibo[41];

        dp[0] = new Fibo(0, 1, 0);
        dp[1] = new Fibo(1, 0, 1);
        dp[2] = new Fibo(2, 1, 1);
        for (int i = 3; i < 41; i++) {
            dp[i] = new Fibo(i, dp[i - 2], dp[i - 1]);
        }

        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(bf.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(dp[current].zeroCount).append(" ").append(dp[current].oneCount);
            System.out.println(sb);
        }
    }

}

