import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] union;
    static List<Integer> knownPerson = new ArrayList<>();
    static List<Integer>[] party;

    // 이거 UNION FIND 집합 구하는 문제
    // 모든 Party를 전부 순회하며 진실을 아는 사람과 함께하는 사람들은 모두 하나의 집합으로 묶음
    // 다시 Party를 순회하여 각 파티에 참여한 모든 사람이 집합에 해당하지 않는다면 count + 1
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        union = new int[N + 1];
        party = new List[M];

        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        for (int i = 0; i < party.length; i++) {
            party[i] = new ArrayList<>();
        }

        st = new StringTokenizer(bf.readLine());
        int knownCount = Integer.parseInt(st.nextToken());

        if (knownCount == 0) {
            System.out.println(M);
            return;
        }

        int knowner = Integer.parseInt(st.nextToken());
        knownPerson.add(knowner);

        while (st.hasMoreTokens()) {
            int person = Integer.parseInt(st.nextToken());
            union(knowner, person);
            knownPerson.add(person);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int count = Integer.parseInt(st.nextToken());

            int person = Integer.parseInt(st.nextToken());
            party[i].add(person);

            for (int c = 1; c < count; c++) {
                int anotherPerson = Integer.parseInt(st.nextToken());
                party[i].add(anotherPerson);
                union(person, anotherPerson);
            }
        }

        int knownGroup = find(knownPerson.get(0));
        int answer = 0;

        for (int i = 0; i < party.length; i++) {
            boolean flag = true;

            for (int p : party[i]) {
                if (find(p) == knownGroup) flag = false;
            }

            if (flag) answer++;
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

    private static int find(int a) {
        if (union[a] == a) return a;
        return union[a] = find(union[a]);
    }
}

