package Do_it_Algorithm;

import java.util.Scanner;

public class Q001Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String Num = sc.next();
        char[] chars = Num.toCharArray();

        int sum = 0;
        for (char c : chars) {
            sum += c - '0';
        }
        System.out.println(sum);
    }
}
