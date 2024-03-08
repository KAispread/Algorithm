import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] union;

    // Union & Find
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        union = new int[N];
        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        int answer = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int findA = find(A);
            int findB = find(B);

            if (findA == findB) {
                answer = i;
                break;
            } else {
                union(findA, findB);
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            union[findB] = findA;
        }
    }

    private static int find(int number) {
        if (union[number] == number) return number;
        return union[number] = find(union[number]);
    }
}
