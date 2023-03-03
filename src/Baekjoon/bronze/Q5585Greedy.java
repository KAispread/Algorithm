package Baekjoon.bronze;

import java.util.Scanner;

/*
* 거스름돈 - Bronze II
* */
public class Q5585Greedy {
    private static final int[] coin = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int change = 1000 - N;
        int count = 0;

        for (int c : coin) {
            if (change >= c) {
                count += change / c;
                change = change % c;
            }
        }

        System.out.println(count);
    }
}
