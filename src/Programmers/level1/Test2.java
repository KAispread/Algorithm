package Programmers.level1;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        solution2(new int[]{1, 3, 2, 5, 4}, 9);
    }

    /*
    * 행렬의 덧셈
    * */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int columnCount = arr1.length;
        int rowCount = arr1[0].length;
        int[][] answer = new int[columnCount][rowCount];

        for (int column = 0; column < columnCount; column++) {
            for (int row = 0; row < rowCount; row++) {
                answer[column][row] = arr1[column][row] + arr2[column][row];
            }
        }
        return answer;
    }

    /*
    *
    * */
    public static int solution2(int[] d, int budget) {
        Arrays.sort(d);
        int maxSupport = 0;
        int total = 0;
        for (int i : d) {
            total += i;
        }
        maxSupport = d.length;
        if (total <= budget) {
            return maxSupport;
        }

        for (int count = d.length - 1; count >= 0; count--) {
            total -= d[count];
            maxSupport--;
            if (total <= budget) {
                return maxSupport;
            }
        }
        return maxSupport;
    }
}
