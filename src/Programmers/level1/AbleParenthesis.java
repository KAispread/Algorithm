package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

/*
* 올바른 괄호
* */
public class AbleParenthesis {
    private static char LEFT = '(';
    private static char RIGHT = ')';

    boolean solution(String s) {
        char[] parenthesis = s.toCharArray();

        int leftCount = 0;
        int rightCount = 0;

        Map<Integer, String>  sdf = new HashMap<>();

        for (char given : parenthesis) {
            if (leftCount == 0 && rightCount == 0 && given == RIGHT) {
                return false;
            }

            if (given == LEFT) {
                leftCount += 1;
            } else if (given == RIGHT) {
                rightCount += 1;
            }

            if (leftCount == rightCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }

        if (leftCount != 0 || rightCount != 0) {
            return false;
        }

        return true;
    }
}
