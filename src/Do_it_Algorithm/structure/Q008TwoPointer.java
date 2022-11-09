package Do_it_Algorithm.structure;

import java.util.Arrays;
import java.util.Scanner;

// 백준 - 1253번 Gold3
public class Q008TwoPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        Arrays.sort(A);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            long find = A[i];
            int k = 0;
            int p = N - 1;

            while (k < p) {
                if (A[k] + A[p] == find) {
                    if(i == k)
                        k++;
                    else if(p == i)
                        p--;
                    else{
                        answer++;
                        break;
                    }
                } else if (A[k] + A[p] < find) {
                    k++;
                } else {
                    p--;
                }
            }
        }
        System.out.println(answer);
    }
}
