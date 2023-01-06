package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* Platinum V - 1948번
* 위상정렬 완벽 활용
* */
public class Q55TopologySort {
    static List<Node>[] node;
    static List<Node>[] oppositeNode;

    public static void main(String[] args)  throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(bf.readLine());
        int R = Integer.parseInt(bf.readLine());
        node = new ArrayList[C + 1];
        oppositeNode = new ArrayList[C + 1];

        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
            oppositeNode[i] = new ArrayList<>();
        }

        int[] topol = new int[node.length];
        StringTokenizer st;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            node[A].add(new Node(B, weight));
            topol[B]++;
            oppositeNode[B].add(new Node(A, weight));
        }
        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] weightN = new int[C + 1];
        while (!queue.isEmpty()) {
            int pol = queue.poll();
            for (Node n : node[pol]) {
                int next = n.getnNode();
                int w = n.getWeight();
                topol[next]--;
                weightN[next] = Math.max(weightN[pol] + w, weightN[next]);

                if (topol[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        Queue<Integer> maxCity = new LinkedList<>();
        maxCity.offer(end);
        int count = 0;

        boolean[] check = new boolean[C + 1];
        check[end] = true;

        while (!maxCity.isEmpty()) {
            int poll = maxCity.poll();

            for (Node n : oppositeNode[poll]) {
                int next = n.getnNode();
                if (n.getWeight() + weightN[next] == weightN[poll]) {
                    count++;

                    if (!check[next]) {
                        maxCity.offer(next);
                        check[next] = true;
                    }
                }
            }
        }

        System.out.println(weightN[end]);
        System.out.println(count);
    }

    static class Node {
        private int nNode;
        private int weight;

        public Node(int nNode, int weight) {
            this.nNode = nNode;
            this.weight = weight;
        }

        private int getnNode() {
            return this.nNode;
        }
        private int getWeight() {
            return this.weight;
        }
    }
}
