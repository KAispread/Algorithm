package Programmers.level1;

/*
 * 최소 직사각형
 * */
public class MinWallet {
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
