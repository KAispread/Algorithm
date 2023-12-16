import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 이분탐색
    // 가장 큰 랜선 -> 가장 큰 랜선의 길이
    // 가장 작은 랜선 -> 1cm
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long minimum = 1;
        long maximum = 0;

        int[] electronicLine = new int[K];

        for (int i = 0; i < K; i++) {
            int current = Integer.parseInt(bf.readLine());
            maximum = Math.max(maximum, current);
            electronicLine[i] = current;
        }
        maximum++;

        long answer = 0;
        while (minimum <= maximum) {
            long mid = (minimum + maximum) / 2;
            long count = 0;

            for (int line : electronicLine) {
                count += line / mid;
            }

            if (count >= N) {
                minimum = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                maximum = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

