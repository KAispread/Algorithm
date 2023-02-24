package Programmers.level2;

import java.util.Stack;

/*
* 뒷 큰수
* */
public class BackBigNumber {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>();

            stack.push(0);
            for (int i = 1; i < numbers.length; i++) {
                while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                answer[stack.pop()] = -1;
            }

            return answer;
        }
    }
}
