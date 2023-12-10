import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();

        System.out.println(BFS(F, S, G, U, D));
    }

    private static String BFS(int max, int current, int goal, int up, int down) {
        boolean[] visited = new boolean[max + 1];
        Queue<int[]> queue = new LinkedList<>();
        visited[current] = true;
        queue.offer(new int[] {current, 1});

        while (!queue.isEmpty()) {
            int[] pivot = queue.poll();
            if (pivot[0] == goal) return String.valueOf(pivot[1] - 1);

            int upFloor = pivot[0] + up;
            int downFloor = pivot[0] - down;

            if (upFloor <= max && !visited[upFloor]) {
                visited[upFloor] = true;
                queue.offer(new int[] {upFloor, pivot[1] + 1});
            }

            if (downFloor > 0 && !visited[downFloor]) {
                visited[downFloor] = true;
                queue.offer(new int[] {downFloor, pivot[1] + 1});
            }
        }

        return "use the stairs";
    }
}
