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

    static class Structure {
        int index;
        int cost;
        int totalCost;

        public Structure(int index, int cost, int totalCost) {
            this.index = index;
            this.cost = cost;
            this.totalCost = totalCost;
        }
    }

    static List<Structure>[] nodes;
    static List<Integer>[] naturalNodes;
    static int[] structureCost;
    static int[] force;

    /*
    목표 건물 : N 번
    N 번 건물을 짓기 위해 필요한 선행 건물을 역순으로 탐색
    class Node 에 이전까지 소요된 시간을 저장
    PriorityQueue 에 다음 지어야할 건물을 저장하여 시간이 이른 순으로 처리

    int time -> 결과값 갱신
    */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            solution(bf);
        }
    }

    public static void solution(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nodes = new List[N+1];
        structureCost = new int[N+1];
        force = new int[N+1];
        naturalNodes = new List[N+1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
            naturalNodes[i] = new ArrayList<>();

            int cost = Integer.parseInt(st.nextToken());
            structureCost[i] = cost;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int required = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            nodes[target].add(new Structure(required, structureCost[required], 0));
            naturalNodes[required].add(target);
            force[target] ++;
        }

        int target = Integer.parseInt(bf.readLine());
        int minimumTime = getMinimumTime(target);
        System.out.println(minimumTime);
    }

    private static int getMinimumTime(int target) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < force.length; i++) {
            if (force[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : naturalNodes[current]) {
                force[next]--;
                if (force[next] == 0) queue.offer(next);
            }

            int max = 0;
            for (Structure before : nodes[current]) {
                max = Math.max(max, structureCost[before.index]);
            }

            if (max != 0) structureCost[current] += max;
        }

        return structureCost[target];
    }
}

