package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* Gold IV - 11657 번
* */
public class Q59BellmanFord {
    static int N, M;
    static long distance[];
    static Edge edges[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 도로를 저장하는 배열
        edges = new Edge[M + 1];

        // 거리를 저장하는 배열
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        // 벨만포드 알고리즘
        distance[1] = 0;

        // 노드의 개수 - 1만큼 반복
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                int cTime = (int) (distance[edge.start] + edge.time);
                // 최단 거리 업데이트
                if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > cTime) {
                    distance[edge.end] = cTime;
                }
            }
        }

        // 음수 사이클 확인
        boolean cycle = false;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];

            int cTime = (int) (distance[edge.start] + edge.time);
            // 최단 거리 업데이트
            if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > cTime) {
                cycle = true;
                break;
            }
        }

        StringBuilder builder = new StringBuilder();
        if (cycle) {
            builder.append("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] != Integer.MAX_VALUE) {
                    builder.append(distance[i]).append("\n");
                } else {
                    builder.append("-1").append("\n");
                }
            }
        }
        System.out.println(builder);
    }

    static class Edge {
        int start, end, time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
