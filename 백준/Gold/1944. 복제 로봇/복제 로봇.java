import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int nodeA;
        int nodeB;
        int length;

        public Edge(int a, int b, int length) {
            this.nodeA = a;
            this.nodeB = b;
            this.length = length;
        }
    }

    static int[] union;
    static int[][] map;
    static final int TEMP = 1000;
    static final Map<Integer, Integer> indexMap = new HashMap<>();
    static final Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.length - o2.length);

    /*
    * 사이클이 생기지 않도록 모든 노드를 이어야함 - 크루스칼 알고리즘
    * 시작점 S를 포함하여 키를 잇는 N - 1개의 최단 거리 간선을 구하면 됨
    * 각 점에서 BFS 알고리즘을 통해 각 노드까지의 거리를 구함 (간선)
    * 크루스칼 알고리즘을 통해 간선을 하나하나 연결함 -> sum 연산으로 각 노드간 거리 저장
    * -> 출력
    *
    * -> 각 칸의 Index = (x * 1000) + y
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        union = new int[M + 2];
        map = new int[N+1][N+1];
        int keyIdx = 1;

        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            String s = bf.readLine();

            for (int j = 1; j <= N; j++) {
                char current = s.charAt(j - 1);

                if (current == 'S' || current == 'K') {
                    map[i][j] = -1;
                    indexMap.put(getKey(j, i), keyIdx);
                    keyIdx++;
                } else {
                    map[i][j] = current - '0';
                }
            }
        }

        // queue 채워넣기
        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) {
            int[] location = getLocation(entry.getKey());
            BFS(location[0], location[1], N);
        }

        // 크루스칼 알고리즘
        int answer = 0;
        int count = 0;

        while (!queue.isEmpty() && count < M) {
            Edge current = queue.poll();

            int findA = find(current.nodeA);
            int findB = find(current.nodeB);

            if (findA != findB) {
                count++;
                answer += current.length;
                union(findA, findB);
            }
        }

        if (count == M) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            union[B] = A;
        }
    }

    private static int find(int a) {
        if (union[a]== a) return a;
        return union[a] = find(union[a]);
    }

    private static int[][] moving = new int[][] {{0,1} ,{0,-1}, {1,0}, {-1,0}};

    private static void BFS(int x, int y, int N) {
        Queue<int[]> bQueue = new LinkedList<>();
        bQueue.offer(new int[] {x, y, 0});
        boolean[][] visited = new boolean[N + 1][N + 1];
        visited[y][x] = true;

        int currentIdx = indexMap.get(getKey(x, y));

        while (!bQueue.isEmpty()) {
            int[] current = bQueue.poll();

            for (int[] move : moving) {
                int tx = current[0] + move[0];
                int ty = current[1] + move[1];

                if (validate(tx, ty, N, visited)) {
                    visited[ty][tx] = true;
                    int len = current[2] + 1;
                    bQueue.offer(new int[] {tx, ty, len});

                    if (map[ty][tx] == -1) {
                        Integer i = indexMap.get(getKey(tx, ty));
                        queue.offer(new Edge(currentIdx, i, len));
                    }
                }
            }
        }
    }

    private static boolean validate(int x, int y, int N, boolean[][] visited) {
        if (x == 0 || y == 0 || x > N || y > N) return false;
        if (visited[y][x]) return false;
        if (map[y][x] == 1) return false;
        return true;
    }

    private static int getKey(int x, int y) {
        return x * TEMP + y;
    }

    private static int[] getLocation(int index) {
        int x = index / TEMP;
        int y = index % TEMP;

        return new int[] {x, y};
    }
}

