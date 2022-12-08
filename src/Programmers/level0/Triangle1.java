package Programmers.level0;

import java.util.Arrays;

/*
* 삼각형의 완성 조건
* */
public class Triangle1 {
    public static void main(String[] args) {

    }

    public int solution(int[] sides) {
        Arrays.sort(sides);
        if (sides[0] + sides[1] > sides[2]) {
            return 1;
        }
        return 2;
    }
}
