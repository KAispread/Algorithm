package Do_it_Algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* 1167번 - Gold III
* 트리의 지름 구하기
* */
public class Q28BFS {
    static List<Node>[] node;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int nodeNumber = Integer.parseInt(st.nextToken());

        node = new List[nodeNumber + 1];
        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int count = 0; count < nodeNumber; count++) {
            st = new StringTokenizer(bf.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int forwardNode = Integer.parseInt(st.nextToken());
                if (forwardNode == -1) {
                    break;
                }
                node[nodeNum].add(new Node(forwardNode, Integer.parseInt(st.nextToken())));
            }
        }

        for (int count = 1; count < node.length; count++) {
            visited = new boolean[nodeNumber + 1];
            DFS(count, 0);
        }
        System.out.println(max);
    }

    private static void DFS(int target, int count) {
        List<Node> targetNode = node[target];
        if (targetNode.isEmpty() || visited[target]) {
            return;
        }

        visited[target] = true;
        for (Node nodes : targetNode) {
            int forward = nodes.getTargetNode();
            int length = nodes.getLength();
            if (!visited[forward]) {
                DFS(forward, count + length);
            }

            if (count > max) {
                max = count;
            }
        }
        visited[target] = false;
    }

    static class Node {
        private final int targetNode;
        private final int length;

        public Node(int targetNode, int length) {
            this.targetNode = targetNode;
            this.length = length;
        }

        public int getTargetNode() {
            return targetNode;
        }

        public int getLength() {
            return length;
        }
    }
}
