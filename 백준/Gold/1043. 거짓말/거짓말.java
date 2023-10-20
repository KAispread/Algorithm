import java.util.List;
import java.util.Scanner;

/*
* Gold IV - 1043번 - 거짓말쟁이가 되긴 싫어
* */
public class Main {
    static int[] unionFind;
    static List<Integer>[] patients;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int person = sc.nextInt();
        int party = sc.nextInt();
        int tNum = sc.nextInt();
        if (tNum == 0) {
            System.out.println(party);
            return;
        }

        unionFind = new int[person + 1];
        for (int i = 1; i < unionFind.length; i++) {
            unionFind[i] = i;
        }
        int[] truth = new int[tNum];

        for (int i = 0; i < tNum; i++) {
            truth[i] = sc.nextInt();
        }

        int[] roots = new int[party];
        int[] one = new int[party];

        for (int i = 0; i < party; i++) {
            int number = sc.nextInt();

            int first = sc.nextInt();
            for (int j = 1; j < number; j++) {
                int part = sc.nextInt();
                union(first, part);
                first = part;
            }

            one[i] = first;
        }

        int answer = 0;
        for (int i = 0; i < one.length; i++) {
            boolean flag = true;
            for (int j = 0; j < truth.length; j++) {
                if (find(one[i]) == find(truth[j])) {
                    flag = false;
                }
            }
            if (flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A != B) {
            unionFind[B] = A;
        }
    }

    private static int find(int a) {
        if (unionFind[a] == a) {
            return a;
        }
        return unionFind[a] = find(unionFind[a]);
    }
}
