package Chapter01;

import java.util.Scanner;

public class Q004Range {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int n = N +1;
        long S[][] = new long[n][n];

        for (int i =1; i < n; i++) {
            for (int j =1; j<n; j++) {
                S[i][j] = sc.nextInt() + S[i-1][j] + S[i][j-1] - S[i-1][j-1];
            }
        }

        long result[] = new long[M];
        for (int i=0; i < M; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            result[i] = S[x2][y2] - S[x2][y1-1] - S[x1-1][y2] + S[x1-1][y1-1];
        }

        for (long re : result) {
            System.out.println(re);
        }
    }
}
