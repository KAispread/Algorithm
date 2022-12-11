package Do_it_Algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 13023번 - Gold V
 * */
public class Q25DFS {
    private final static int CONDITION = 4;
    static List<Integer>[] node;
    static boolean arrive = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        node = new List[N];
        for (int i = 0; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int count = 0; count < M; count++) {
            st = new StringTokenizer(bf.readLine());
            int friendA = Integer.parseInt(st.nextToken());
            int friendB = Integer.parseInt(st.nextToken());
            node[friendA].add(friendB);
            node[friendB].add(friendA);
        }

        for (int count = 0; count < N; count++) {
            List<Integer> preFriends = new ArrayList<>();
            DFS(preFriends, count, 0);
            if (arrive) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void DFS(List<Integer> preFriend, int targetNode, int count) {
        if (count == CONDITION || arrive) {
            arrive = true;
            return;
        }
        for (int integer : node[targetNode]) {
            if (!preFriend.contains(integer)) {
                DFS(preFriend, integer, count + 1);
            }
        }
        if (preFriend.contains(targetNode)) preFriend.remove(targetNode);
    }
}
