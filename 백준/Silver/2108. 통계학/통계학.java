import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    /*
    * 1. 산술 평균 -> N 개의 수를 N으로 나눔 int count
    * 2. 중앙 값 -> N개의 수를 저장하여 정렬 후 가운데 Index
    * 3. 최빈 값 -> int 가장 많은 횟수 저장, Map 에 가장 많은 횟수 저장, 이후 PriorityQueue 에서 poll 두번
    * 4. 범위 -> N개의 수들 중 최댓값과 최솟값의 차이, 배열 저장
    * */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> lists = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxCount = 1;

        for (int i = 0; i < N; i++) {
            int current = sc.nextInt();
            int currentCount = map.getOrDefault(current, 0) + 1;

            lists.add(current);
            sum += current;
            map.put(current, currentCount);

            if (currentCount == maxCount) {
                queue.offer(current);
            } else if (currentCount > maxCount) {
                queue.clear();
                queue.offer(current);
                maxCount = currentCount;
            }
        }

        Collections.sort(lists);

        System.out.println(Math.round((double) sum / (double) N));
        System.out.println(lists.get(N / 2));

        if (queue.size() == 1) {
            System.out.println(queue.poll());
        } else {
            queue.poll();
            System.out.println(queue.poll());
        }

        System.out.println(lists.get(N - 1) - lists.get(0));
    }

}

