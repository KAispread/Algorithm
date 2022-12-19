package Programmers.level1;

import java.util.Stack;

/*
* 햄버거 만들기
* - 문자열로 변환하고 치환하였을 때 성능 아주 나쁨
* - Stack 자료구조로 스택의 크기가 일정 이상이면 검사하게끔 함
* */
public class MakeBurger {
    private static int[] sequence = new int[] {1, 2, 3, 1};
    public int solution(int[] ingredient) {
        Stack<Integer> buffer = new Stack<>();
        int answer = 0;

        for (int i = 0; i < ingredient.length; i++) {
            buffer.push(ingredient[i]);

            if (buffer.size() >= 4) {
                boolean flag = true;
                for (int j = sequence.length; j > 0; j--) {
                    if (buffer.get(buffer.size() - j) != sequence[sequence.length - j]) {
                        flag = false;
                    }
                }
                if(flag) {
                    for (int a : sequence) {
                        buffer.pop();
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}
