package Programmers.level0;

/*
* 숨어있는 숫자의 덧셈 (1)
* */
public class HideNumberSum1 {
    class Solution {
        public int solution(String my_string) {
            int answer = 0;
            char[] myChar = my_string.toCharArray();
            for (int i = 0; i < myChar.length; i++) {
                char c = myChar[i];
                if (c >= '0' && c <= '9') {
                    answer += c - 48;
                }
            }
            return answer;
        }
    }
}
