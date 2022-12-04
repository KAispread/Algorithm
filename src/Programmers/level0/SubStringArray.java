package Programmers.level0;

import java.util.ArrayList;
import java.util.List;

/*
* 잘라서 배열로 저장하기
* */
public class SubStringArray {
    public static void main(String[] args) {
        solution("abc1Addfggg4556b", 6);
    }

    public static String[] solution(String my_str, int n) {
        int count = my_str.length() / n;
        if (my_str.length() % n > 0) {
            count++;
        }
        String[] answer = new String[count];

        for (int i = 0; i < answer.length; i++) {
            int start = i * n;
            int end = (i + 1) * n;
            if (end > my_str.length()) {
                end = my_str.length();
            }
            answer[i] = my_str.substring(start, end);
        }

        return answer;
    }
}
