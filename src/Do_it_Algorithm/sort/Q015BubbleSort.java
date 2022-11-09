package Do_it_Algorithm.sort;

import java.util.Scanner;

/* 백준 - 2750 Bronze I
* 단순 오름차순 정렬 문제
* 버블 정렬로 풀어보기
* */

public class Q015BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numList = new int[N];

        for (int i = 0; i < N; i++) {
            numList[i] = sc.nextInt();
        }

        for (int i = N - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (numList[j] > numList[j+1]) {
                    flag = false;
                    int temp = numList[j];
                    numList[j] = numList[j+1];
                    numList[j+1] = temp;
                }
            }

            if (flag) break;
        }

        for (int i : numList) {
            System.out.println(i);
        }
    }
}
