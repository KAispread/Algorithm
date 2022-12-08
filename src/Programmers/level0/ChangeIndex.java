package Programmers.level0;

/*
* 인덱스 바꾸기
*
 */
public class ChangeIndex {
    public static void main(String[] args) {

    }

    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char[] chars = my_string.toCharArray();
        char c1 = my_string.charAt(num1);
        char c2 = my_string.charAt(num2);
        chars[num1] = c2;
        chars[num2] = c1;
        return new String(chars);
    }
}
