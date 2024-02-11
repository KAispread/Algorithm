import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int nodeA;
        int nodeB;
        double weight;

        public Edge(int nodeA, int nodeB, double weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }
    }

    static double[][] stars;
    static Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.weight));
    static int[] union;

    /*
    * 모든 점에서 각 다른 점까지 Edge 생성
    * 크루스칼 알고리즘으로 최단 거리를 가진 Edge 추가
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        stars = new double[N + 1][2];
        union = new int[N + 1];

        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars[i][0] = x;
            stars[i][1] = y;
        }

        for (int i = 1; i < stars.length; i++) {
            for (int j = i + 1; j < stars.length; j++) {
                double ax = stars[i][0];
                double ay = stars[i][1];
                double bx = stars[j][0];
                double by = stars[j][1];

                double dist = calculateDistance(ax, ay, bx, by);

                queue.offer(new Edge(i, j, dist));
            }
        }

        int edgeCount = 0;
        double sum = 0;

        while (!queue.isEmpty() && edgeCount < N - 1) {
            Edge current = queue.poll();
            int findA = find(current.nodeA);
            int findB = find(current.nodeB);

            if (findA == findB) continue;
            union(findA, findB);

            sum += current.weight;
            edgeCount++;
        }

        System.out.println(sum);
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            union[findB] = findA;
        }
    }

    private static int find(int a) {
        if (union[a] == a) return a;
        return union[a] = find(union[a]);
    }

    private static double calculateDistance(double ax, double ay, double bx, double by) {
        return Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }
}

