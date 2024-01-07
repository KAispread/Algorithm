import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // map 의 모든 정점에서 시작해서 상,하,좌,우 중 가장 최대인 수를 찾고 그 지점으로 이동, 4회까지만 반복 -> 최댓값 갱신
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Map<String, String> password = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();
            password.put(site, pw);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String site = bf.readLine();
            sb.append(password.get(site)).append("\n");
        }
        System.out.println(sb);
    }

}

