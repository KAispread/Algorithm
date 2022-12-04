package Programmers.level0;

import java.util.StringTokenizer;

/*
* OX 퀴즈
* */
public class OXquiz {
    public static void main(String[] args) {
        solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"});
    }

    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int count = 0; count < quiz.length; count++) {
            if (isCorrectAnswer(quiz[count].trim())) {
                answer[count] = "O";
                continue;
            }
            answer[count] = "X";
        }
        return answer;
    }

    private static boolean isCorrectAnswer(String question) {
        StringTokenizer token = new StringTokenizer(question, " ");
        int A = Integer.parseInt(token.nextToken());
        String operator = token.nextToken();
        int B = Integer.parseInt(token.nextToken());
        token.nextToken();
        int answer = Integer.parseInt(token.nextToken());

        int result = calculate(operator, A, B);
        return answer == result;
    }

    private static int calculate(final String operator, final int A, final int B) {
        if (operator.equals("+")) {
            return A + B;
        }
        return A - B;
    }
}
