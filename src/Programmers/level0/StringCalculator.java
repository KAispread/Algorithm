package Programmers.level0;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class StringCalculator {
    public static void main(String[] args) {

    }

    public int solution(String my_string) {
        StringTokenizer token = new StringTokenizer(my_string, " ");
        List<String> operators = Arrays.stream(Calculator.values())
                .map(Calculator::getOperator)
                .collect(Collectors.toList());

        int total = Integer.parseInt(token.nextToken());
        while (token.hasMoreTokens()) {
            String element = token.nextToken();
            if (operators.contains(element)) {
                int number = Integer.parseInt(token.nextToken());
                total = Calculator.calculate(element, total, number);
            }
        }
        return total;
    }

    enum Calculator {
        PLUS("+",(a, b) -> a + b),
        MINUS("-", (a, b) -> a - b);

        private final String operator;
        private final BiFunction<Integer, Integer, Integer> expression;

        Calculator(String operator, BiFunction<Integer, Integer, Integer> expression) {
            this.operator = operator;
            this.expression = expression;
        }

        public static int calculate(String operator, Integer A, Integer B) {
            return getOperator(operator).expression.apply(A, B);
        }

        private static Calculator getOperator(String operator) {
            return Arrays.stream(Calculator.values())
                    .filter(calculator -> calculator.operator.equals(operator))
                    .findAny().orElseThrow();
        }

        public String getOperator() {
            return operator;
        }
    }
}
