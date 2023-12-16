import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = 0;
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            M = Math.max(M, current);
            scores[i] = current;
        }

        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += (double) scores[i] / (double) M * 100.0d;
        }

        System.out.println(sum / (double) N);
    }
}

