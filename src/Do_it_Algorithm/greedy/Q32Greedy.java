package Do_it_Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 11047번 - Silver I
* */
public class Q32Greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }

        int sum = 0;
        int count = 0;
        for (int i = coin.length - 1; i >= 0; i--) {
            if (coin[i] <= K - sum) {
                int cnt = (K - sum) / coin[i];
                count += cnt;
                sum += (coin[i] * cnt);
            }
        }

        System.out.println(count);
    }
}
