import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 가장 작은 값과 가장 큰 값을 포인터로 잡고, 기준값보다 작아지면 prePoint 를 +1, 커지면 postPoint + 1
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] number = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int prePoint = 0;
        int postPoint = N - 1;
        int answer = Integer.MAX_VALUE;

        while (prePoint < postPoint) {
            int sum = number[prePoint] + number[postPoint];

            if (Math.abs(sum) < Math.abs(answer)) answer = sum;

            if (sum == 0) {
                break;
            } else if (sum > 0) {
                postPoint--;
            } else {
                prePoint++;
            }
        }

        System.out.println(answer);
    }
}
