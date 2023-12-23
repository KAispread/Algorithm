import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int command = sc.nextInt();

            if (command == 0) {
                System.out.println(getMinimum(queue));
            } else {
                queue.offer(command);
            }
        }
    }

    private static int getMinimum(Queue<Integer> queue) {
        if (queue.isEmpty()) return 0;
        return queue.poll();
    }
}

