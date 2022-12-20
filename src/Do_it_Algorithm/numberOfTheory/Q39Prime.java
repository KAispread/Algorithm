package Do_it_Algorithm.numberOfTheory;

import java.util.Scanner;

public class Q39Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (!isPrime(N) || !isPalindrom(N)) {
            N++;
        }
        System.out.println(N);
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrom(int n) {
        if (n < 10) {
            return true;
        }
        char[] nums = String.valueOf(n).toCharArray();
        int point = nums.length / 2;
        for (int i = 0; i < point; i++) {
            if (nums[i] != nums[nums.length -i -1]) {
                return false;
            }
        }
        return true;
    }
}
