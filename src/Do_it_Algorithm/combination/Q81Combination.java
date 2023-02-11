package Do_it_Algorithm.combination;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q81Combination {
    static int[] fac;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fac = new int[N];

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int mul = 2;
        fac[fac.length - 1] = 1;
        for (int i = fac.length - 2; i >= 0; i--) {
            fac[i] = fac[i + 1] * mul;
            mul++;
        }

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
    }

    private static String numArrayK(int k, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while (idx >= arr.length) {
            if (fac[idx] <= k) {
                for ()
            }
        }
    }
}
