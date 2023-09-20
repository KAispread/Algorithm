package Programmers.kit.stack_queue;

// LEVEL2 - 올바른 괄호
public class CorrectParentheses {

    public static class Try {
        public static char LEFT = '(';
        public static char RIGHT = ')';

        public static boolean solution(String s) {
            int left = 0;
            int right = 0;

            for (char c : s.toCharArray()) {
                if (c == LEFT) {
                    left++;
                } else {
                    right++;
                    if (right > left) return false;
                    if (left > 0 && left == right) {
                        left = 0;
                        right = 0;
                    }
                }
            }

            if (left != 0 || right != 0) return false;

            return true;
        }
    }

    public static class Answer {
        private static char LEFT = '(';
        private static char RIGHT = ')';

        boolean solution(String s) {
            char[] parenthesis = s.toCharArray();

            int leftCount = 0;
            int rightCount = 0;

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
}
