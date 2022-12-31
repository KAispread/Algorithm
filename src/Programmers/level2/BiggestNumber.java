package Programmers.level2;

import java.util.Arrays;

/*
* 가장 큰 수
* - 예외인 경우를 철저하게 따질 필요가 있음
* */
public class BiggestNumber {
    public String solution(int[] numbers) {
        String[] number = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            number[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(number, (
                (String o1, String o2) -> {
                    String s1 = o1 + o2;
                    String s2 = o2 + o1;
                    return (int) (Long.parseLong(s2) - Long.parseLong(s1));
                }
        ));
        if (number[0].equals("0")) return "0";

        StringBuilder builder = new StringBuilder();
        for (String num : number) {
            builder.append(num);
        }

        return builder.toString();
    }
}
