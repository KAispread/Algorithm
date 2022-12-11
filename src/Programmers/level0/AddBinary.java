package Programmers.level0;

import java.util.ArrayList;
import java.util.List;

/*
* 이진수의 합
* */
public class AddBinary {
    public static void main(String[] args) {
        solution("10", "11");
    }

    public static String solution(String bin1, String bin2) {
        int max = Math.max(bin1.length(), bin2.length());
        if (bin1.length() < max) {
            bin1 = makeZero(max - bin1.length()) + bin1;
        } else if (bin2.length() < max) {
            bin2 = makeZero(max - bin2.length()) + bin2;
        }
        StringBuilder builder = new StringBuilder();
        boolean upper = false;
        List<Integer> result = new ArrayList<>();
        for (int count = bin1.length() - 1; count >= 0; count--) {
            int pointA = bin1.charAt(count) - 48;
            int pointB = bin2.charAt(count) - 48;
            int sum = 0;
            if (upper) {
                sum = pointA + pointB + 1;
            } else {
                sum = pointA + pointB;
            }

            if (sum >= 2) {
                result.add(sum - 2);
                upper = true;
            } else {
                result.add(sum);
                upper = false;
            }
        }
        if (upper) result.add(1);
        for (int i = result.size() - 1; i >= 0 ; i--) {
            builder.append(result.get(i));
        }
        return builder.toString();
    }

    private static String makeZero(int count) {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
