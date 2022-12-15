package Do_it_Algorithm.greedy;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
* 1715번 - Gold IV
* */
public class Q33Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }
        if (N == 1) {
            System.out.println(queue.peek());
            return;
        }

        int count = 0;
        while (queue.size() != 1) {
            int pubA = queue.poll();
            int pubB = queue.poll();
            int sum = pubA + pubB;
            queue.add(sum);
            count += sum;
        }

        System.out.println(count);
    }
}
