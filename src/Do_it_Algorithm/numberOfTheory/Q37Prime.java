package Do_it_Algorithm.numberOfTheory;

import java.util.Scanner;

/*
* 1929번 - Silver II
* 소수 구하기
* */
public class Q37Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N + 1];

        for (int num = 2; num <= N; num++) {
            A[num] = num;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
