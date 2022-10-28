package Do_it_Algorithm;

import java.util.Scanner;

public class Q003Range {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int S[] = new int[N + 1];

        for (int i = 1; i < N+1; i++) {
            S[i] = sc.nextInt() + S[i-1];
        }

        int result[] = new int[M];
        for (int a =0; a < M; a++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            result[a] = S[j] - S[i - 1];
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
