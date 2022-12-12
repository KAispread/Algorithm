package Do_it_Algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1260번 - Silver II
 * DFS 와 BFS
 * */
public class Q26BFS {
    private static List<Integer>[] node;
    private static final List<Integer> DFSRoute = new ArrayList<>();
    private static final List<Integer> BFSRoute = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        node = new List[N + 1];
        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            node[nodeA].add(nodeB);
            node[nodeB].add(nodeA);
        }

        for (int i = 1; i < node.length; i++) {
            if (!node[i].isEmpty()) {
                Collections.sort(node[i]);
            }
        }

        DFSRoute.add(V);
        DFS(V);
        StringBuilder builder = new StringBuilder();
        for (Integer route : DFSRoute) {
            builder.append(route).append(" ");
        }
        builder.append("\n");

        BFS(V);
        for (Integer route : BFSRoute) {
            builder.append(route).append(" ");
        }

        System.out.println(builder);
    }

    private static void DFS(int target) {
        List<Integer> targetNode = node[target];
        if (targetNode.isEmpty()) {
            return;
        }
        for (Integer node : targetNode) {
            if (!DFSRoute.contains(node)) {
                DFSRoute.add(node);
                DFS(node);
            }
        }
    }

    private static void BFS(int target) {
        Queue<Integer> BFSQueue = new LinkedList<>();
        BFSQueue.add(target);

        while (!BFSQueue.isEmpty()) {
            Integer pollNode = BFSQueue.poll();
            BFSRoute.add(pollNode);
            List<Integer> targetNode = node[pollNode];

            for (Integer integer : targetNode) {
                if (!BFSRoute.contains(integer) && !BFSQueue.contains(integer)) {
                    BFSQueue.add(integer);
                }
            }
        }
    }
}
