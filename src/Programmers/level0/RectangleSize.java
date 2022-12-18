package Programmers.level0;

/*
* 직사각형 넓이 구하기
* */
public class RectangleSize {
    class Solution {
        public int solution(int[][] dots) {
            int x = dots[0][0];
            int y = dots[0][1];

            int xLength = 0;
            int yLength = 0;

            for (int i = 1; i < dots.length; i++) {
                if (x == dots[i][0]) {
                    yLength = Math.abs(y - dots[i][1]);
                }

                if (y == dots[i][1]) {
                    xLength = Math.abs(x - dots[i][0]);
                }
            }

            return xLength * yLength;
        }
    }
}
