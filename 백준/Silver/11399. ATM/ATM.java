import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // Blue 색깔은 미리 계산 후 0으로 초기화 -> 이후 배열 복사 -> 적록색약인 경우, 아닌 경우 따로 BFS Go
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] time = new int[N];

        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        int timeCount = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            timeCount += sum + time[i];
            sum += time[i];
        }
        System.out.println(timeCount);
    }
}

