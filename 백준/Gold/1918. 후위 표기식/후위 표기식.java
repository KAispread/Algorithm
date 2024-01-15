import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // Stack
    // 문자열이 나오면 그대로 출력
    // 연산자가 나오면 Stack에 들어있는 연산자의 우선순위를 보고 Stack에 들어있는 연산자의 우선순위가 높다면 pop() 반복
    // '(' 가 나오면 일단 push()
    // ')' 가 나오면 '(' 가 나올때까지 pop()
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String operator = st.nextToken();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < operator.length(); i++) {
            char current = operator.charAt(i);

            switch (current) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(current)) {
                        sb.append(stack.pop());
                    }
                    stack.push(current);
                    break;
                case '(':
                    stack.push(current);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(current);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    private static int getPriority(char operator) {
        if (operator == '(' || operator == ')') return 0;
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return -1;
    }
}

