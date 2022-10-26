package Chapter01;

import java.util.Scanner;

public class Q005Range {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long S[] = new long[N];
        float C[] = new float[M];

        long result = 0;
        S[0] = sc.nextInt();

        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }
        for (int i =0; i < N; i++) {
            int remain = (int) (S[i] % M);
            if (remain == 0) result++;
            C[remain]++;
        }

        for (int i =0; i < M; i++) {
            if (C[i] > 1) {
                result += (int) (C[i] * (C[i] -1) / 2);
            }
        }
        System.out.println(result);
    }
}

