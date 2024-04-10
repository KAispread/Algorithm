import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Map<Integer, Boolean> map = new TreeMap<>();

        int aCount = Integer.parseInt(st.nextToken());
        int bCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < aCount; i++) {
            map.put(Integer.parseInt(st.nextToken()), true);
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < bCount; i++) {
            map.put(Integer.parseInt(st.nextToken()), false);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                sb.append(entry.getKey()).append(" ");
                count++;
            }
        }

        System.out.println(count);
        if (count > 0) {
            System.out.println(sb.toString());
        }
    }
}
