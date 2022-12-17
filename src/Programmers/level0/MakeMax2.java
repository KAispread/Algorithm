package Programmers.level0;

import java.util.Arrays;

/*
* 최댓값 만들기 2
* */
public class MakeMax2 {
    public static void main(String[] args) {

    }

    public int solution(int[] numbers) {
        if (numbers.length == 2) {
            return getMultiple(numbers, 0, 1);
        }
        int[] given = Arrays.copyOf(numbers, numbers.length);

        Arrays.sort(given);
        return Math.max(getMultiple(given, 0, 1), getMultiple(given, given.length-2, given.length-1)) ;
    }

    private int getMultiple(int[] numbers, int start, int end) {
        return numbers[start] * numbers[end];
    }
}
