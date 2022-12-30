package Programmers.level1;

import java.util.ArrayList;
import java.util.List;

/*
* 가장 큰 수
* - 예외인 경우를 철저하게 따질 필요가 있음
* */
public class BiggestNumber {
    public String solution(int[] numbers) {
        List<String> number = new ArrayList<>();
        for (int num : numbers) {
            number.add(String.valueOf(num));
        }

        number.sort(
                (String o1, String o2) -> {
                    String s1 = o1 + o2;
                    String s2 = o2 + o1;
                    return (int) (Long.parseLong(s2) - Long.parseLong(s1));
                }
        );
        if (number.get(0).equals("0")) return "0";

        return String.join("", number);
    }
}
