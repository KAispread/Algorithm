package Programmers.level0;

import java.util.HashSet;
import java.util.Set;

/*
* 삼각형의 완성 조건
* */
public class Triangle2 {
    public static void main(String[] args) {
        solution(new int[] {11, 7});
    }

    public static int solution(int[] sides) {
        Set<Integer> triangleSides = new HashSet<>();
        triangleSides.addAll(getSidesInLongest(sides));
        triangleSides.addAll(getOtherLongest(sides));
        return triangleSides.size();
    }

    private static Set<Integer> getSidesInLongest(int[] sides) {
        int max = 0;
        int normal = 0;
        for (int side : sides) {
            if (max < side) {
                normal = max;
                max = side;
            } else {
                normal = side;
            }
        }
        Set<Integer> side = new HashSet<>();

        int trSide = max - normal + 1;
        while (trSide <= max) {
            side.add(trSide);
            trSide++;
        }
        return side;
    }

    private static Set<Integer> getOtherLongest(int[] sides) {
        int sideSum = 0;
        int max = 0;
        for (int side : sides) {
            if (max < side) {
                max = side;
            }
            sideSum += side;
        }

        Set<Integer> side = new HashSet<>();

        int trSide = max + 1;
        while (trSide < sideSum) {
            side.add(trSide);
            trSide++;
        }
        return side;
    }
}
