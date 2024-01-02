import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // 같은 부위의 N개의 선택지에 대해서 N개중에 하나를 고르는 경우의 수 = N + 1 (안 입는 경우 포함)
    // 맨 마지막에 아무것도 안 입은 경우 -1 이 답
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Map<String, Integer> clothes = new HashMap<>();
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            int clothesCount = Integer.parseInt(bf.readLine());

            for (int i = 0; i < clothesCount; i++) {
                st = new StringTokenizer(bf.readLine());
                st.nextToken();
                String part = st.nextToken();

                clothes.put(part, clothes.getOrDefault(part, 0) + 1);
            }

            int answer = 1;
            for (Map.Entry<String, Integer> entry : clothes.entrySet()) {
                answer *= entry.getValue() + 1;
            }

            System.out.println(answer - 1);
            clothes.clear();
        }
    }

}

