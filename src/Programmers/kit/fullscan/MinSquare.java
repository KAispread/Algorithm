package Programmers.kit.fullscan;

import java.util.LinkedList;
import java.util.Queue;

// LEVEL1 - 최소 직사각형
public class MinSquare {

    public int solution(int[][] sizes) {
        int maxInWallet = 0;
        int minInWallet = 0;

        for (int[] s : sizes) {
            maxInWallet = Math.max(Math.max(s[0], s[1]), maxInWallet);
            minInWallet = Math.max(Math.min(s[0], s[1]), minInWallet);
        }

        Queue<Character> queue = new LinkedList<>();

        return maxInWallet * minInWallet;
    }

    static class Answer {
        public int solution(int[][] sizes) {
            int max = 0;
            int min = 0;

            for (int[] size : sizes) {
                int x = Math.max(size[0], size[1]);
                int n = Math.min(size[0], size[1]);
                if (max < x) {
                    max = x;
                }
                if (min < n) {
                    min = n;
                }
            }
            return max * min;
        }
    }
}
