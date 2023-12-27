import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 이분탐색
    // min - max 값의 중간값을 갱신해가며 기준 높이만큼 나무를 가져갈 수 있는지 판단.
    // 기준 높이의 나무만큼 가져갈 수 있다면 높이를 올리고, 아니라면 높이를 낮춤
    // 최소 - 0, 최대 - 나무 최대 크기
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        int[] woods = new int[N];
        long answer = 0;
        long max = 0;
        long min = 0;

        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
            max = Math.max(woods[i], max);
        }

        while (min <= max) {
            long mid = (min + max) / 2;
            long ableToCutHeight = 0;

            for (int wood : woods) {
                if (wood > mid) ableToCutHeight += wood - mid;
            }

            if (ableToCutHeight >= H) {
                min = mid + 1;
                answer = Math.max(mid, answer);
            } else max = mid - 1;
        }

        System.out.println(answer);
    }
}

