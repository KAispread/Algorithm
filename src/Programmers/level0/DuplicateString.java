package Programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DuplicateString {
    public static void main(String[] args) {
        System.out.println(solution("people"));

    }

    public static String solution(String my_string) {
        return Arrays.stream(my_string.split("")).distinct().collect(Collectors.joining());
    }
}
