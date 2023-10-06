package Programmers.level2.stack_queue;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

// LEVEL2 - 괄호 회전하기
public class RotatingParentheses {

    /*
    완탐문제인듯
    문자열의 길이만큼 한 문자씩 회전시켜서 올바른 문자열인지 판별
    */
    static final Map<Character, Character> map = Map.of(
            '}', '{',
            ')', '(',
            ']', '['
    );

    public int solution(String s) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            queue.offer(c);
        }

        int answer = 0;
        if (isCorrect(queue)) answer++;

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());

            if (isCorrect(queue)) answer++;
        }

        return answer;
    }

    private boolean isCorrect(Queue<Character> s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s) {
            if (isRight(c)) {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
                continue;
            }
            stack.push(c);
        }

        return stack.isEmpty() ? true : false;
    }

    private boolean isRight(Character c) {
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if (c == entry.getKey()) return true;
        }

        return false;
    }

}
