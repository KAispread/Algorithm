package Do_it_Algorithm.sort;

import java.util.Scanner;

/* 백준 1427 Silver V
*  선택 정렬 기초
* */
public class Q017SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        char[] chars = N.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int max = i;
            for (int j = i; j < chars.length; j ++) {
                if (chars[j] > chars[max]) {
                    max = j;
                }
            }
            if (chars[max] > chars[i]) {
                char temp = chars[i];
                chars[i] = chars[max];
                chars[max] = temp;
            }
        }

        for (char c : chars) {
            System.out.print(c);
        }
    }
}
