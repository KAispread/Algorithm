import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Stone {
        int weight;
        int cost;

        public Stone(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }

    // 보석의 가치가 비싼 순으로 정렬
    // 가방을 순회하며 비싼 보석을 가방에 넣을 수 있는지 판단 후 넣었다면 boolean[] 체크
    // 가방도 큰 것부터 시작해서 최대한 작은 가방에 넣을 수 있는지 확인
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stone[] stones = new Stone[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            stones[i] = new Stone(weight, cost);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            bags[i] = weight;
        }

        Arrays.sort(bags);
        Arrays.sort(stones, Comparator.comparingInt(o -> o.weight));
        long sum = 0;

        int idx = 0;
        // 보석 중 가격이 높은 순 정렬
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < K; i++) {
            int weight = bags[i];

            while (idx < N && stones[idx].weight <= weight) {
                queue.offer(stones[idx].cost);
                idx++;
            }

            if (!queue.isEmpty()) {
                sum += queue.poll();
            }
        }

        System.out.println(sum);
    }
}
