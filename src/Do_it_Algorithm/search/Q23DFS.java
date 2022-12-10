package Do_it_Algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
* 11724번 - Silver V
* */
public class Q23DFS {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] nearList = new List[N + 1];
        boolean[] checkList = new boolean[N + 1];
        Arrays.fill(checkList, false);

        for (int i = 1; i < nearList.length; i++) {
            nearList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            nearList[nodeA].add(nodeB);
            nearList[nodeB].add(nodeA);
        }

        int count = 0;
        do {
            DFS(checkList, nearList);
            count++;
        } while (!isAllPath(checkList));

        System.out.println(count);
    }

    private static boolean isAllPath(boolean[] checkList) {
        for (int i = 1; i < checkList.length; i++) {
            if (!checkList[i]) {
                return false;
            }
        }
        return true;
    }

    private static void DFS(boolean[] checkList, List<Integer>[] nearList) {
        int target = 0;
        for (int i = 1; i < checkList.length; i++) {
            if (!checkList[i]) {
                target = i;
                break;
            }
        }
        if (target == 0) {
            return;
        }

        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(target);
        checkList[target] = true;
        while (!nodeStack.isEmpty()) {
            Integer pop = nodeStack.pop();

            for (int i = 0; i < nearList[pop].size(); i++) {
                Integer node = nearList[pop].get(i);
                if (!checkList[node]) {
                    nodeStack.push(node);
                    checkList[node] = true;
                }
            }
        }
    }
}
