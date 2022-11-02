package Do_it_Algorithm;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

/* 백준 - 1874 Silver V
/* Stack 활용

  StringBuilder 성능 최고 - BufferedWriter 는 출력초과가 뜸.
*/

public class Q011Stack {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numArray = new int[N];
        for (int i = 0; i < N; i++) {
            numArray[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int buffer = 1;
        int count = 0;
        boolean isAble = true;

        StringBuilder sb = new StringBuilder();
        for (int i =0; i < numArray.length; i++) {
            if (numArray[i] >= buffer) {
                while (numArray[i] >= buffer) {
                    stack.push(buffer++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.pop();

                if (n > numArray[i]) {
                    System.out.println("NO");
                    isAble = false;
                    break;
                }
                sb.append("-\n");
            }
        }

        if (isAble) {
            System.out.println(sb.toString());
        }
    }
}
