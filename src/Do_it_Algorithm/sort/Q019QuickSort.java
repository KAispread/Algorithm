package Do_it_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 백준 11004 Silver V
 *  퀵정렬 기초
 *  pivot 위치 중간으로 설정 후 첫 번째 요소와 swap
 * */
public class Q019QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[] A = new int[N];
        token = new StringTokenizer(bf.readLine());
        for (int i =0; i< N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }
        quickSort(A, 0 , N -1,K -1);
        System.out.println(A[K - 1]);
    }

    private static void quickSort(int[] A, int start, int end, int K) {
        if (start < end) {
            int pivot = partition(A, start, end);
            if (pivot == K) {
                return;
            }
            else if (K < pivot) {
                quickSort(A, start, pivot - 1, K);
            }
            quickSort(A, pivot + 1, end, K);
        }
    }

    private static int partition(int[] A, int start, int end) {
        int M = (start + end) /2;
        swap(A, start, M);
        int pivot = A[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (pivot < A[j] && j > start) {
                j--;
            }
            while (i < j && pivot >= A[i] && i < end) {
                i++;
            }
            swap(A, i, j);
        }

        A[start] = A[i];
        A[i] = pivot;
        return i;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
