package Programmers.level0;
/*
* 겹치는 선분의 길이
* */
public class DuplicateLine {
    public static void main(String[] args) {
        solution(new int[][] {{0, 1}, {2, 5}, {3, 9}});
    }

    public static int solution(int[][] lines) {
        int max = -Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] line : lines) {
            if (line[0] < min) {
                min = line[0];
            }
            if (line[1] > max) {
                max = line[1];
            }
        }
        int[] A = new int[max - min];

        for (int[] line : lines) {
            int lineLength = line[1] - line[0];
            int beginIndex = line[0] - min;
            for (int i = beginIndex; i < beginIndex + lineLength; i++) {
                A[i] += 1;
            }
        }

        int answer = 0;
        for (int i : A) {
            if (i > 1) {
                answer++;
            }
        }
        return answer;
    }
}
