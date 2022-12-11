package Programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* A를 B로 만들기
* */
public class AtoB {
    public static void main(String[] args) {

    }

    public int solution(String before, String after) {
        if (before.length() != after.length()) {
            return 0;
        }
        String[] pre = before.split("");
        List<String> strings = new ArrayList<>(Arrays.asList(after.split("")));
        for (String preString : pre) {
            strings.remove(preString);
        }
        if (strings.size() == 0) {
            return 1;
        }
        return 0;
    }
}
