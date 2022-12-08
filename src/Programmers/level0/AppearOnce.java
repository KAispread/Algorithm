package Programmers.level0;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AppearOnce {
    public static void main(String[] args) {

    }

    public String solution(String s) {
        Set<Character> once = new TreeSet<>();
        s = s.replaceAll(" ", "");
        while (s.length() > 0) {
            char c = s.charAt(0);
            int before = s.length();
            s = s.replaceAll(String.valueOf(c), "");
            int i = before - s.length();
            if (i == 1) {
                once.add(c);
            }
        }
        return once.stream().map(character -> String.valueOf(character)).collect(Collectors.joining());
    }
}
