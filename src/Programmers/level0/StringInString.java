package Programmers.level0;

/*
* 문자열 안에 문자열
* */
public class StringInString {
    public static void main(String[] args) {

    }

    public int solution(String str1, String str2) {
        if (str1.contains(str2)) {
            return 1;
        }
        return 2;
    }
}
