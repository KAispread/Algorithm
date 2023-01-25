package Do_it_Algorithm.tree;

import java.util.Scanner;

/*
* 1991번 - Silver I
* */
public class Q70BinaryTree {
    static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // 노드의 개수 - 왼쪽,오른쪽
        tree = new int[26][2];

        for (int i = 0; i < N; i++) {
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            // '.' 일 경우 -1 저장
            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }

            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int now) {
        if (now == - 1) {
            return;
        }
        // 루트 -> 왼쪽 -> 오른쪽
        System.out.print((char) (now + 'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }

    private static void inOrder(int now) {
        if (now == - 1) {
            return;
        }
        // 왼쪽 -> 루트 -> 오른쪽
        inOrder(tree[now][0]);
        System.out.print((char) (now + 'A'));
        inOrder(tree[now][1]);
    }

    private static void postOrder(int now) {
        if (now == - 1) {
            return;
        }
        // 왼쪽 -> 오른쪽 -> 루트
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.print((char) (now + 'A'));
    }
}
