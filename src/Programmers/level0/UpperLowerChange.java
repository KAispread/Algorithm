package Programmers.level0;

public class UpperLowerChange {
    public static void main(String[] args) {

    }

    public String solution(String my_string) {
        char[] stringChars = my_string.toCharArray();
        for (int count = 0; count < stringChars.length; count++) {
            char c = stringChars[count];
            if (c >= 'A' && c <= 'Z') {
                stringChars[count] += 32;
            } else {
                stringChars[count] -= 32;
            }
        }
        return new String(stringChars);
    }
}
