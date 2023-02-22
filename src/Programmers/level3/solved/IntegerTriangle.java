package Programmers.level3.solved;

/*
* 정수 삼각형
* */
public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
}
