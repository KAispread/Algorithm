import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 바이토닉 수열은 무조건 '기준점' 이 존재함
    // 각 기준점에서 왼방향으로의 부분 수열 개수와 오른쪽으로의 부분 수열 개수의 합이 가장 큰 수열이 가장 긴 바이토닉 수열이 됨
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] naturalOrderDp = new int[N];
        int[] reverseOrderDp = new int[N];
        int[] numbers = new int[N];

        Arrays.fill(naturalOrderDp, 1);
        Arrays.fill(reverseOrderDp, 1);

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int current = numbers[i];

            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < current && naturalOrderDp[j] >= naturalOrderDp[i]) naturalOrderDp[i] = naturalOrderDp[j] + 1;
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            int current = numbers[i];

            for (int j = i + 1; j < N; j++) {
                if (numbers[j] < current && reverseOrderDp[j] >= reverseOrderDp[i]) reverseOrderDp[i] = reverseOrderDp[j] + 1;
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(naturalOrderDp[i] + reverseOrderDp[i] - 1, max);
        }

        System.out.println(max);
    }
}

