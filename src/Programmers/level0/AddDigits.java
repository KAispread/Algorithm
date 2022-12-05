package Programmers.level0;

import java.util.ArrayList;
import java.util.List;
/*
* 자리수 더하기
* */
public class AddDigits {
    public static void main(String[] args) {

    }

    public int solution(int n) {
        List<Integer> digits = separateDigits(n);
        return addEachElement(digits);
    }

    private List<Integer> separateDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        char[] charDigit = String.valueOf(number).toCharArray();
        for (char c : charDigit) {
            int num = c - 48;
            digits.add(num);
        }
        return digits;
    }

    private int addEachElement(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
