import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<String, String> nameToIndex = new HashMap<>();
        Map<String, String> indexToName = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String pocketMon = bf.readLine();
            String index = String.valueOf(i);
            nameToIndex.put(pocketMon, index);
            indexToName.put(index, pocketMon);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String command = bf.readLine();
            char c = command.charAt(0);

            if (c >= '0' && c <= '9') {
                sb.append(indexToName.get(command)).append("\n");
            } else {
                sb.append(nameToIndex.get(command)).append("\n");
            }

        }
        System.out.println(sb);
    }

}

