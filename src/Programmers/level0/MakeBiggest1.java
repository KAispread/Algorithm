package Programmers.level0;

import java.util.Arrays;

/*
* 최댓값 만들기
* */
public class MakeBiggest1 {
    class Solution {
        public int solution(int[] numbers) {
            int lastIndex = numbers.length - 1;
            Arrays.sort(numbers);
            return numbers[lastIndex] * numbers[lastIndex - 1];
        }
    }
}
