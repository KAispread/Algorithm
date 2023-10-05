package Programmers.kit.sort;

import java.util.ArrayList;
import java.util.List;

// LEVEL 2 -> 가장 큰 수
public class BiggestNumber {

    public String solution(int[] numbers) {
        List<String> charList = new ArrayList<>();

        for (int n : numbers) {
            charList.add(String.valueOf(n));
        }

        charList.sort((o1, o2) -> {
            Long s1 = Long.parseLong(o1 + o2);
            Long s2 = Long.parseLong(o2 + o1);

            return (int) (s2 - s1);
        });
        if (charList.get(0).equals("0")) return "0";

        return String.join("", charList);
    }

    static class Answer {
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
}
