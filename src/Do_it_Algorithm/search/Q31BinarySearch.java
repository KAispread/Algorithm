package Do_it_Algorithm.search;

import java.io.IOException;
import java.util.Scanner;

/*
* 1300번 - Gold IV
* */
public class Q31BinarySearch {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1, end = K;
        long ans = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(middle / i, N);
            }

            if (cnt < K) {
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }
        }
        System.out.println(ans);
    }
}
