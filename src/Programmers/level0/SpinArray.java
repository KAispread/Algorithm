package Programmers.level0;

/*
* 배열 회전시키기
* */
public class SpinArray {
    class Solution {
        public int[] solution(int[] numbers, String direction) {
            int[] answer = new int[numbers.length];
            if (direction.equals("left")) {
                for (int i = 1; i < numbers.length; i++) {
                    answer[i - 1] = numbers[i];
                }
                answer[answer.length - 1] = numbers[0];
                return answer;
            }
            for (int i = 1; i < numbers.length; i++) {
                answer[i] = numbers[i - 1];
            }
            answer[0] = numbers[numbers.length - 1];
            return answer;
        }
    }
}
