package Do_it_Algorithm;

import java.util.Scanner;

public class Q002Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int score[] = new int[N];
        double sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            if (max < score[i]) {
                max = score[i];
            }
        }

        for (int sco : score) {
            sum += ((float)sco / (float)max * 100);
        }

        System.out.println(sum / N);
    }
}
