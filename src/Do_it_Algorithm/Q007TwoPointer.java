package Do_it_Algorithm;

import java.util.Arrays;
import java.util.Scanner;

// 백준 - 1940 번
public class Q007TwoPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] parts = new int[N];

        for (int i = 0; i < N; i++) {
            parts[i] = sc.nextInt();
        }
        Arrays.sort(parts);

        int i = 0;
        int j = N - 1;

        int answer = 0;
        while (i < j) {
            if (parts[i] + parts[j] == M) {
                answer++;
                i++;
                j--;
            } else if (parts[i] + parts[j] < M) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(answer);
    }
}
