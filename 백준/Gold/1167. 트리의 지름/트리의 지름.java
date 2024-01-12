import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int nodeNumber = Integer.parseInt(st.nextToken());

        A = new ArrayList[nodeNumber + 1];
        for (int i = 1; i < A.length; i++) {
            A[i] = new ArrayList<>();
        }

        for (int count = 0; count < nodeNumber; count++) {
            st = new StringTokenizer(bf.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int forwardNode = Integer.parseInt(st.nextToken());
                if (forwardNode == -1) {
                    break;
                }
                int value = Integer.parseInt(st.nextToken());
                A[nodeNum].add(new Edge(forwardNode, value));
            }
        }
        distance = new int[nodeNumber + 1];
        visited = new boolean[nodeNumber + 1];
        BFS(1);
        int max = 0;
        for (int i = 2; i <= nodeNumber; i++) {
            if (distance[max] < distance[i]){
                max = i;
            }
        }
        distance = new int[nodeNumber + 1];
        visited = new boolean[nodeNumber + 1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[nodeNumber]);
    }
    
    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (Edge edge: A[nowNode]) {
                int e = edge.e;
                int v = edge.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[nowNode] + v;
                }
            }
        }
    }
    
    static class Edge {
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
