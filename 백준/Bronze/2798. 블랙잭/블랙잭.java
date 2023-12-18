import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        Arrays.sort(cards);
        int answer = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int z = j + 1; z < N; z++) {
                    int current = cards[i] + cards[j] + cards[z];
                    if (current <= M) answer = Math.max(answer, current);
                }
            }
        }

        System.out.println(answer);
    }

}

