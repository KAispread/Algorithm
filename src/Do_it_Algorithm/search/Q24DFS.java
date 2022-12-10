package Do_it_Algorithm.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 2023번 - Gold V
* */
public class Q24DFS {
    private static List<Integer> result = new ArrayList<>();
    private static int N;
    private static int[] evens = {1, 3, 5, 7, 9};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void DFS(int number, int length) {
        if (isPrime(number)) {
            if (length == N) {
                result.add(number);
                return;
            }
            int a = number * 10;
            for (int even : evens) {
                DFS(a + even, length + 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
