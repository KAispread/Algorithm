package Do_it_Algorithm.sort;

import java.util.Scanner;

/* 백준 11399 Silver III
 *  삽입 정렬 기초
 *  인덱스의 요소를 선택하여 정렬된 범위의 적절한 위치에 삽입
 * */
public class Q018InsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        for (int i = 0 ; i < N; i++) {
            P[i]  = sc.nextInt();
        }

        // 삽입 정렬
        for (int i = 1; i < P.length; i++) {
            int insertPoint = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (P[j] < P[i]) {
                    insertPoint = j + 1;
                    break;
                }
                if (j == 0) {
                    insertPoint = 0;
                    break;
                }
            }

            if (insertPoint == -1) throw new IllegalArgumentException();

            for (int j = i; j > insertPoint; j--) {
                int temp = P[j - 1];
                P[j - 1] = P[j];
                P[j] = temp;
            }
        }
        //

        int sum = 0;
        int result = 0;
        for (int minutes : P) {
            sum += minutes;
            result += sum;
        }

        System.out.println(result);
    }
}
