package Programmers.level0;

import java.util.Arrays;
import java.util.List;
/*
* 배열의 유사도
* */
public class SimilarArray {
    public static void main(String[] args) {

    }

    public int solution(String[] s1, String[] s2) {
        if (s1.length > s2.length) {
            return countSameElement(s2, s1);
        }
        return countSameElement(s1, s2);
    }

    private int countSameElement(final String[] S1, final String[] S2) {
        List<String> S2List = Arrays.asList(S2);
        int count = 0;
        for (String element : S1) {
            if (S2List.contains(element)) {
                count++;
            }
        }
        return count;
    }
}
