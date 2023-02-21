package Programmers.level2;

/*
* 크기가 작은 부분 문자열
* */
public class LessSubString {
    public int solution(String t, String p) {
        int tl = t.length();
        int pl = p.length();
        int answer = 0;

        for (int i = 0; i < tl - pl + 1; i++) {
            if (0 >= t.substring(i, i + pl).compareTo(p)) {
                answer++;
            }
        }

        return answer;
    }
}
