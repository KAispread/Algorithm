package Programmers.level0;

/*
* 공던지기
* */
public class ThrowBall {
    class Solution {
        public int solution(int[] numbers, int k) {
            int start = 1;
            for (int i = 0; i < k - 1; i++) {
                start += 2;
            }
            return start % numbers.length;
        }
    }
}
