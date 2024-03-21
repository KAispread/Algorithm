import java.util.*;

class Solution {
    
    private Map<Character, Integer> priority = new HashMap<>();
    private List<Character> operation = new ArrayList<>();
    private char topOperation;
    private String exp; 
    private long max;
        
    // 최상위 연산자가 아니라면 연산자와 숫자를 따로 Stack에 저장한다.
    // 연산자 Stack에 저장된 연산자와 현재 연산자를 비교하여 현재 연산자의 우선순위가 더 높다면 Stack을 소모한다.
    // 루프문 이후 Stack이 남아있다면 전부 소모한다.
    public long solution(String expression) {
        exp = expression;
        char[] exchar = expression.toCharArray();
        Set<Character> opset = new HashSet<>();
        
        // 연산자를 구함 
        for (int i = 0; i < exchar.length; i++) {
            if (!(exchar[i] >= '0' && exchar[i] <= '9')) opset.add(exchar[i]);
        }
        for (char c : opset) {
            operation.add(c);
        }
        
        operate(0, new boolean[operation.size()]);
        
        return max;
    }
    
    // 연산자 경우의 수
    private void operate(int index, boolean[] marked) {
        if (index == marked.length) {
            runExpression();
            return;
        }
        
        for (int i = 0; i < marked.length; i++) {
            // operation 우선순위 부여
            if (!marked[i]) {
                char o = operation.get(index);
                
                if (i == marked.length - 1) {
                    topOperation = o;
                }
                
                marked[i] = true;
                priority.put(o, i);
                operate(index + 1, marked);
                marked[i] = false;
            }
        }
    }
    
            private void runExpression() {
            Stack<Long> numberStack = new Stack<>();
            Stack<Character> operationStack = new Stack<>();

            int index = 0;
            long sum = 0;
            for (int i = 0; i < exp.length(); i++) {
                char current = exp.charAt(i);
                if (!(current >= '0' && current <= '9')) {
                    numberStack.push(Long.parseLong(exp.substring(0, i)));
                    index = i;
                    break;
                }
            }

            for (int i = index; i < exp.length(); i++) {
                char current = exp.charAt(i);

                // 연산자일경우
                if (!(current >= '0' && current <= '9')) {
                    if (operationStack.isEmpty()) {
                        operationStack.push(current);
                        continue;
                    }

                    while (!operationStack.isEmpty() && priority.get(operationStack.peek()) >= priority.get(current)) {
                        char oper = operationStack.pop();
                        long num1 = numberStack.pop();
                        long num2 = numberStack.pop();

                        numberStack.push(calculate(num2, num1, oper));
                    }
                    operationStack.push(current);
                    continue;
                }

                // 숫자일경우
                boolean flag = false;
                for (int j = i + 1; j < exp.length(); j++) {
                    current = exp.charAt(j);
                    if (!(current >= '0' && current <= '9')) {
                        numberStack.push(Long.parseLong(exp.substring(i, j)));
                        i = j - 1;
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    numberStack.push(Long.parseLong(exp.substring(i, exp.length())));
                    break;
                }
            }

            while (!operationStack.isEmpty()) {
                char oper = operationStack.pop();
                long num1 = numberStack.pop();
                long num2 = numberStack.pop();

                numberStack.push(calculate(num2, num1, oper));
            }

            max = Math.max(max, Math.abs(numberStack.pop()));
        }
    
    private long calculate(long a, long b, char operation) {
        if (operation == '-') {
            return a - b;
        } else if (operation == '+') {
            return a + b;
        } else {
            return a * b;
        }
    }
}