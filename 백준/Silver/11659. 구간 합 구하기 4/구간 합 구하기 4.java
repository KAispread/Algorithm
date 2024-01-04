import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] sum;

    // Blue 색깔은 미리 계산 후 0으로 초기화 -> 이후 배열 복사 -> 적록색약인 경우, 아닌 경우 따로 BFS Go
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sum = new int[N + 1];
        st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + number;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(sum[end] - sum[start - 1]);
        }
    }

}

