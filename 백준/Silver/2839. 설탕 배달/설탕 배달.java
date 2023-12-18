import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = Integer.MAX_VALUE;
        int fiveCount = N / 5;

        while (fiveCount >= 0) {
            int remain = N - 5 * fiveCount;
            int threeCount = remain / 3;

            if (fiveCount * 5 + threeCount * 3 == N) answer = Math.min(fiveCount + threeCount, answer);

            fiveCount--;
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

}

