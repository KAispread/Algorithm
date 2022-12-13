package Programmers.level0;

import java.util.ArrayList;
import java.util.List;

/*
* 평행 구하기
* */
public class Collateral {
    public static void main(String[] args) {

    }

    public int solution(int[][] dots) {
        List<Double> gradient = new ArrayList<>();
        for (int i = dots.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int increX = dots[i][0] - dots[j][0];
                int increY = dots[i][1] - dots[j][1];
                double grad = increY / (double) increX;
                gradient.add(grad);
            }
        }
        int duplicateCount = (int) (gradient.size() - gradient.stream().distinct().count());
        if (duplicateCount > 0) {
            return 1;
        }
        return 0;
    }
}
