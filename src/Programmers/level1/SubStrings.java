package Programmers.level1;
/*
* 프로그래머스 레벨 1 - 문자열 나누기
* */
public class SubStrings {
    public static void main(String[] args) {
        System.out.println(solution("banana"));
    }

    public static int solution(String s) {
        int answer = 0;
        String subString = s;

        while (subString != null) {
            subString = getSubString(subString);
            answer++;
        }

        return answer;
    }

    public static String getSubString(String s) {
        if (s == null || s.equals("") || s.length() == 1) {
            return null;
        }

        int xCount = 1;
        int otherCount = 0;
        char x = s.charAt(0);
        for (int count = 1; count < s.length(); count++) {
            if (xCount == otherCount) {
                return s.substring(count);
            }
            char current = s.charAt(count);
            if (current == x) {
                xCount++;
                continue;
            }
            otherCount++;
        }
        return null;
    }
}
