package Baekjoon.Silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2042Range {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int n = N + 1;
        int[] num = new int[n];
        long[] S = new long[n];

        for (int i = 1; i< n; i++) {
            num[i] = sc.nextInt();
            S[i] = num[i] + S[i-1];
        }

        List<Long> result = new ArrayList<>();
        for (int j = 0; j< M+K; j++) {
            int a =sc.nextInt();
            int b =sc.nextInt();
            int c =sc.nextInt();

            if (a == 1)  {
                int diff = c - num[b];
                for (int i = b; i < n; i++) {
                    S[i] += diff;
                }
            } else if (a == 2) {
                result.add(S[c] - S[b - 1]);
            }
        }

        for (Long aLong : result) {
            System.out.println(aLong);
        }
    }
}
