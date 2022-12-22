package Do_it_Algorithm.numberOfTheory;

import java.util.Scanner;

/*
* 1850번 - Silver II
*  최대 공약수 구하기
* */
public class Q43Euclidean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long count = euclidean(A, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    private static long euclidean(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        while (max % min != 0) {
            long temp = max;
            max = min;
            min = temp % min;
        }
        return min;
    }
}
