package Do_it_Algorithm.numberOfTheory;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
* 1033번 - Gold II
* */
public class Q44Euclidean {
    static ArrayList<Node>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int N =sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new Node(b,p,q));
            A[b].add(new Node(a,q,p));
            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i = 0; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            builder.append(D[i] / mgcd).append(" ");
        }
        System.out.println(builder);
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void DFS(int node) {
        visited[node] = true;
        for (Node i : A[node]) {
            int next = i.getB();
            if (!visited[next]) {
                D[next] = D[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }

    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
