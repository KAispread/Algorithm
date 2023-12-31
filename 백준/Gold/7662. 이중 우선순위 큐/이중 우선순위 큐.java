import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    static final char INSERT = 'I';
    static final char DELETE = 'D';

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int operatorCount = Integer.parseInt(bf.readLine());

            for (int c = 0; c < operatorCount; c++) {
                st = new StringTokenizer(bf.readLine());
                char operator = st.nextToken().charAt(0);
                Integer number = Integer.parseInt(st.nextToken());

                if (operator == INSERT) {
                    treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
                } else {
                    delete(number);
                }
            }

            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
                continue;
            }

            System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            treeMap.clear();
        }
    }

    private static void delete(int flag) {
        if (treeMap.isEmpty()) return;

        if (flag == 1) {
            int lastKey = treeMap.lastKey();
            int count = treeMap.get(lastKey);

            if (count <= 1) {
                treeMap.remove(lastKey);
            } else {
                treeMap.put(lastKey, count - 1);
            }
        } else {
            int firstKey = treeMap.firstKey();
            int count = treeMap.get(firstKey);

            if (count <= 1) {
                treeMap.remove(firstKey);
            } else {
                treeMap.put(firstKey, count - 1);
            }
        }
    }
}

