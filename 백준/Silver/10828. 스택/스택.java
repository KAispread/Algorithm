import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String command = bf.readLine();
            run(stack, command);
        }
    }

    private static void run(Stack<Integer> stack, String command) {
        if (command.contains("push")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            stack.push(number);
        } else if (command.equals("pop")) {
            if (!stack.isEmpty()) {
                System.out.println(stack.pop());
                return;
            }
            System.out.println(-1);
        } else if (command.equals("size")) {
            System.out.println(stack.size());
        } else if (command.equals("empty")) {
            int flag = stack.isEmpty() ? 1 : 0;
            System.out.println(flag);
        } else {
            if (!stack.isEmpty()) {
                System.out.println(stack.peek());
                return;
            }
            System.out.println(-1);
        }
    }
}

