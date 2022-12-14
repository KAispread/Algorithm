package Programmers.level0;

import java.util.ArrayList;
import java.util.List;

/*
* 숨어있는 숫자의 덧셈 (2)
* */
public class HideNumberSum {
    public static void main(String[] args) {
        solution("aAb1B2cC34oOp");
    }

    public static int solution(String my_string) {
        char[] chars = my_string.toCharArray();
        List<Integer> number = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i];
            if (c >= 48 && c <= 58) {
                builder.append(c - 48);
            }
            if ( i == chars.length - 1 || chars[i+1] >= 65) {
                String numeric = builder.toString();
                builder = new StringBuilder();
                if (numeric.length() > 0) {
                    number.add(Integer.valueOf(numeric));
                }
            }
        }

        int sum = 0;
        for (Integer num : number) {
            sum += num;
        }
        return sum;
    }
}
