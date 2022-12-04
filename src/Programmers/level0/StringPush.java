package Programmers.level0;
/*
* 문자열 밀기
* */
public class StringPush {
    public static void main(String[] args) {
        solution("hello", "ohell"); // return 1
    }

    public static int solution(String A, String B) {
        int answer = 0;
        for (int count = 0; count < A.length(); count++) {
            int lastIndex = A.length() - 1;
            char c = A.charAt(lastIndex);
            A = c + A.substring(0, lastIndex);
            answer++;
            if (A.equals(B)) {
                return answer;
            }
        }
        return -1;
    }
}
