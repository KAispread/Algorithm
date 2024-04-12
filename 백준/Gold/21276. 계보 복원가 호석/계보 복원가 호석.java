import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static Map<String, List<String>> childMap = new TreeMap<>();
    static Map<String, List<String>> parentMap = new HashMap<>();
    static Map<String, Integer> forces = new HashMap<>();

    // 제일 아래 세대 = 위상이 0인 사람부터 시작하여 조상의 자식에 추가 조상이 자기 자신의 윗 조상이 없다면 root로 판별
    // TreeMap<String, List<String>> = 자기 자식의 수
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < K; i++) {
            String name = st.nextToken();
            forces.put(name, 0);
            childMap.put(name, new ArrayList<>());
            parentMap.put(name, new ArrayList<>());
        }

        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();

            parentMap.get(child).add(parent);
            forces.put(parent, forces.getOrDefault(parent, 0) + 1);
        }

        Queue<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> entry : forces.entrySet()) {
            if (entry.getValue() == 0) queue.offer(entry.getKey());
        }

        List<String> rootParent = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();

            List<String> parents = parentMap.get(current);
            if (parents.isEmpty()) {
                rootParent.add(current);
                continue;
            }

            String directParent = null;
            int directForces = 987654321;

            for (String parent : parents) {
                int force = forces.get(parent) - 1;
                forces.put(parent, force);

                if (force == 0) {
                    queue.offer(parent);
                }

                if (directForces > force) {
                    directForces = force;
                    directParent = parent;
                }
            }

            if (directParent != null) {
                childMap.get(directParent).add(current);
            }
        }

        System.out.println(rootParent.size());
        StringBuilder sb = new StringBuilder();
        for (String root : rootParent) {
            sb.append(root).append(" ");
        }
        System.out.println(sb.toString());

        for (Map.Entry<String, List<String>> entry : childMap.entrySet()) {
            sb = new StringBuilder();
            List<String> values = entry.getValue();
            sb.append(entry.getKey()).append(" ").append(values.size()).append(" ");

            for (String child : values) {
                sb.append(child).append(" ");
            }

            System.out.println(sb.toString());
        }
    }
}
