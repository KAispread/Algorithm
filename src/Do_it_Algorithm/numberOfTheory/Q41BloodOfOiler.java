package Do_it_Algorithm.numberOfTheory;

import java.util.Scanner;

/*
* 11689번 - 오일러의 피 함수 구현
* */
public class Q41BloodOfOiler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = n;
        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                result = result - result / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            result = result - result / n;
        }
        System.out.println(result);
    }
}
