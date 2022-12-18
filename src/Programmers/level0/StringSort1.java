package Programmers.level0;

import java.util.*;

/*
* 문자열 정렬하기
* */
public class StringSort1 {

    public int[] solution(String myString) {
        int[] ints = Arrays.stream(myString.replaceAll("[A-Z|a-z]", "").split("")).sorted().mapToInt(Integer::parseInt).toArray();
        return ints;
    }
}
