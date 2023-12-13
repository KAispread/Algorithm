import java.util.List;
import java.util.Scanner;

/*
* 파도반 수열 - Silver III
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int T = sc.nextInt();
        long[] P = new long[103];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;

        for (int i = 0; i < T; i ++) {
            int N = sc.nextInt();

            for (int a = 6; a <= N; a++) {
                P[a] = P[a - 1] + P[a - 5];
            }

            System.out.println(P[N]);
        }
    }
}
