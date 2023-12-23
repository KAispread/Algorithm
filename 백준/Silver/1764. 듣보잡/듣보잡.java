import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int heardCount = Integer.parseInt(st.nextToken());
        int sawCount = Integer.parseInt(st.nextToken());
        Map<String, Boolean> heardMap = new HashMap<>();

        for (int i = 0; i < heardCount; i++) {
            heardMap.put(bf.readLine(), true);
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < sawCount; i++) {
            String seen = bf.readLine();

            if (heardMap.containsKey(seen)) {
                answer.add(seen);
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (String a : answer) {
            System.out.println(a);
        }
    }

}

