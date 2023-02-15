package Do_it_Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 13398번 - 연속 합 구하기
* */
public class Q89DP {
    static long[] L;
    static long[] R;
    static long[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        L = new long[N + 1];
        R = new long[N + 1];
        num = new long[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        long answer = num[1];
        L[1] = num[1];
        // 첫 번째 숫자부터 i번째 수까지 도출할 수 있는 최대 값
        for (int i = 2; i <= N; i++) {
            L[i] = Math.max(num[i], L[i - 1] + num[i]);
            answer = Math.max(L[i], answer);
        }

        R[N] = num[N];
        // 수열의 끝에서부터 length - i까지 도출할 수 있는 최대 값
        for (int i = N - 1; i >= 1; i--) {
            R[i] = Math.max(num[i], R[i + 1] + num[i]);
        }

        for (int i = 2; i < N; i++) {
            answer = Math.max(L[i - 1] + R[i + 1], answer);
        }

        System.out.println(answer);
    }
}
