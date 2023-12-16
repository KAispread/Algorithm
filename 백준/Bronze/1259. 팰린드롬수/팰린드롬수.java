import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    // 수가 짝수일 경우 N / 2 개까지 Stack 에 저장후 꺼내면서 비교
    // 수가 홀수일 경우 N / 2 개까지 Stack 에 저장후 가운데 수 무시 이후 꺼내면서 비교
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while (true) {
            String current = bf.readLine();
            if (current.equals("0")) return;
            int idx = 0;

            for (int i = 0; i < current.length() / 2; i++) {
                stack.push(current.charAt(i));
                idx++;
            }

            if (current.length() % 2 != 0) idx++;

            boolean isBreaked = false;
            for (int i = idx; i < current.length(); i++) {
                if (stack.pop() != current.charAt(i)) {
                    System.out.println("no");
                    isBreaked = true;
                    break;
                }
            }

            if (!isBreaked) System.out.println("yes");

            stack.clear();
        }

    }


}

