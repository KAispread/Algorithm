package Programmers.level2;

import java.util.Stack;

/*
* 큰 수 만들기
* */
public class MakeBigNumber {
    public static void main(String[] args) {
        solution("1231234", 3);
    }

    public static String solution(String number, int k) {
        int[] nums = new int[number.length()];
        int k1 = k;

        for (int i = 0; i < number.length(); i++) {
            nums[i] = number.charAt(i) - '0';
        }


        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];

            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                int p = stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length - k1; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
