package Do_it_Algorithm.DP;

import java.util.Scanner;
import java.util.Stack;

/*
* 9252번 - 최장 공통 부분 수열 찾기 (LCS)
* */
public class Q90DP {
    static int[][] LCS;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] subB = sc.next().split("");
        String[] subA = sc.next().split("");

        LCS = new int[subA.length+1][subB.length+1];

        for (int a = 1; a <= subA.length; a++) {
            for (int b = 1; b <= subB.length; b++) {
                if (subA[a - 1].equals(subB[b - 1])) {
                    LCS[a][b] = LCS[a - 1][b - 1] + 1;
                } else {
                    LCS[a][b] = Math.max(LCS[a - 1][b], LCS[a][b - 1]);
                }
            }
        }

        if (LCS[subA.length][subB.length] == 0) {
            System.out.println("0");
            return;
        }

        System.out.println(LCS[subA.length][subB.length]);
        int aIdx = subA.length;
        int bIdx = subB.length;


        Stack<String> stack = new Stack<>();
        while (LCS[aIdx][bIdx] > 0) {
            if (subA[aIdx - 1].equals(subB[bIdx - 1])) {
                stack.add(subA[aIdx - 1]);
                aIdx--;
                bIdx--;
            } else {
                if (LCS[aIdx - 1][bIdx] < LCS[aIdx][bIdx - 1]) {
                    bIdx--;
                } else {
                    aIdx--;
                }
            }
        }

        // 거꾸로 출력
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
