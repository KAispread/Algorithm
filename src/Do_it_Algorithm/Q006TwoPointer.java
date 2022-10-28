package Do_it_Algorithm;

import java.util.Scanner;

public class Q006TwoPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start_index = 1;
        int end_index = 1;
        int current = 1;
        int result = 1;

        while (start_index < (int) (N / 2)) {
            if (current < N) {
                end_index++;
                current += end_index;
            } else if (current > N) {
                current -= start_index;
                start_index++;
            } else {
                result++;
                end_index++;
                current += end_index;
            }
        }
        System.out.println(result);
    }
}
