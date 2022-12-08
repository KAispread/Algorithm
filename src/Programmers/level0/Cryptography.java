package Programmers.level0;
/*
* 암호 해독
*/
public class Cryptography {
    public static void main(String[] args) {
        solution("dfjardstddetckdaccccdegkas", 4);
    }

    public static String solution(String cipher, int code) {
        StringBuilder answer = new StringBuilder();
        int count = cipher.length() / code;
        cipher = "-" + cipher;

        for (int i = 1; i <= count; i++) {
            int index = i * code;
            answer.append(cipher.charAt(index));
        }
        return answer.toString();
    }
}
