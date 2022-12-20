package Do_it_Algorithm.numberOfTheory;

import java.math.BigInteger;
import java.util.Scanner;

/*
* 1016번 - Gold I
* 제곱이 아닌 수 찾기
* */
public class Q40Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextInt();
        long max = sc.nextInt();

        boolean[] Check = new boolean[(int) (max - min + 1)];
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = min / pow;
            if (min % pow != 0) {
                start++;
            }
            for (long j = start; pow * j <= max; j++) {
                Check[(int) ((j * pow) - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!Check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
