package Programmers.level0;

import java.util.Arrays;

/*
* 문자열 정렬하기 (2)
* */
public class SortString {
    public static void main(String[] args) {

    }

    public String solution(String my_string) {
        String lowerString = my_string.toLowerCase();
        char[] chars = lowerString.toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }
}
