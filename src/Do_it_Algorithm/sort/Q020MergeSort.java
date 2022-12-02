package Do_it_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 백준 2751 SilverV
 *  병합 정렬
 *  수를 가장 작은 그룹으로 나눈 뒤 그룹을 합치며 정렬
 * */
public class Q020MergeSort {
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        A = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <=N; i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }
        merge_sort(1, N);
        for (int i = 1; i <= N; i++) {
            System.out.println(A[i]);
        }
    }

    private static void merge_sort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        int m = s + (e - s) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
