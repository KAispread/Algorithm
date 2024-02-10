import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int nodeA;
        int nodeB;
        int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }
    }

    static Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    static int[] union;

    /* 노드를 정의
    // 간선을 PriorityQueue 에 저장 -> 간선의 가중치가 낮은순으로 정렬
    // 간선을 하나씩 꺼내어 두 노드가 같은 집합에 속해있는지 확인
    // 같은 집합에 속해있지 않다면 두 노드를 같은 집합으로 만들고 간선을 선택
    // 같은 집합에 속해있다면 간선을 버림
    // 모든 간선을 확인할때까지 반복
    // 선택된 간선의 가중치를 더함
    // 선택된 간선의 가중치를 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        union = new int[V+1];

        for (int i = 2; i <= V; i++) {
            union[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            queue.offer(new Edge(nodeA, nodeB, cost));
        }

        int edgeCount = 0;
        long answer = 0;

        while (!queue.isEmpty() && edgeCount < V - 1) {
            Edge current = queue.poll();

            int findA = find(current.nodeA);
            int findB = find(current.nodeB);

            if (findA == findB) continue;

            union(findA, findB);
            edgeCount++;
            answer += current.cost;
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        if (a != b) {
            union[b] = a;
        }
    }

    private static int find(int number) {
        if (union[number] == number) return number;
        return union[number] = find(union[number]);
    }
}

