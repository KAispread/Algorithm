import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            treeMap.put(number, 1);
            numbers[i] = number;
        }

        int size = treeMap.size() - 1;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int key = entry.getKey();
            treeMap.put(key, size);
            size--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(treeMap.get(numbers[i])).append(" ");
        }
        System.out.println(sb);
    }

}

