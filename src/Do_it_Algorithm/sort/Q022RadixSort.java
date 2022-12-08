package Do_it_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 10986번 - Silver V
* 수 정렬하기 3
* */
public class Q022RadixSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(bf.readLine());
            if (A[i] > max) {
                max = A[i];
            }
        }
        int totalCount = String.valueOf(max).length();
        bf.close();
        Radix_sort(A, totalCount);
        StringBuilder sb = new StringBuilder();
        for (int i : A) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    public static void Radix_sort(int[] A, int max_size) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while (count != max_size) {
            int[] bucket = new int[10];
            for (int i = 0; i < A.length; i++) {
                int currentJarisu = A[i] / jarisu % 10;
                bucket[currentJarisu]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = A.length - 1; i >= 0; i--) {
                int bucketIndex = A[i] / jarisu % 10;
                int outputIndex = bucket[bucketIndex] - 1;
                output[outputIndex] = A[i];
                bucket[bucketIndex]--;
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }
            jarisu *= 10;
            count++;
        }
    }
}
