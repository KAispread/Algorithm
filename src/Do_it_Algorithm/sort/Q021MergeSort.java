package Do_it_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 백준 1517 Gold I
*  버블소트 알고리즘에서 swap 이 몇 번 발생했는지 구하라
*  -> 병합정렬을 수행하며 변한 index 값을 정렬할 때까지 더한다.
* */
public class Q021MergeSort {
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        A = new int[N + 1];
        tmp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        merge_sort(1, N);
        System.out.println(result);
    }

    private static void merge_sort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int middle = start + (end - start) / 2;
        merge_sort(start, middle);
        merge_sort(middle + 1, end);
        for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }
        int count = start;
        int index1 = start;
        int index2 = middle + 1;
        while (index1 <= middle && index2 <= end) {
            if (tmp[index1] > tmp[index2]) {
                A[count] = tmp[index2];

                // 뒤쪽 데이터 값이 작은 경우 result 업데이트
                result = result + index2 - count;

                count++;
                index2++;
            } else {
                A[count] = tmp[index1];
                count++;
                index1++;
            }
        }
        while (index1 <= middle) {
            A[count] = tmp[index1];
            count++;
            index1++;
        }

        while (index2 <= end) {
            A[count] = tmp[index2];
            count++;
            index2++;
        }
    }
}
