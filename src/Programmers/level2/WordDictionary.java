package Programmers.level2;

import java.util.Map;

/*
* 모음사전
* DFS 로 모든 경우의 수 계산
* */
public class WordDictionary {
    public static void main(String[] args) {
        solution("AAAAE");
    }
    static final int MAX_LENGTH = 5;
    static int[] count = new int[MAX_LENGTH];
    static Map<String, Integer> key = Map.of(
            "A", 1,
            "E", 2,
            "I", 3,
            "O", 4,
            "U", 5);
    static int target;
    static int answer = 0;
    static boolean flag = false;

    public static int solution(String word) {
        target = convertNumber(word);

        DFS(0, 0);
        return answer;
    }

    private static void DFS(int num, int depth) {
        if (num == target) {
            flag = true;
            return;
        }
        if (depth >= MAX_LENGTH) {
            return;
        }

        for (int i = 1; i <= MAX_LENGTH; i++) {
            if (flag) {
                return;
            }
            int next = convertNumber(num, i);
            answer++;
            DFS(next, depth + 1);
        }
    }

    private static int convertNumber(int original, int add) {
        return original * 10 + add;
    }

    private static int convertNumber(String word) {
        String[] words = word.split("");

        int result = 0;
        for (String w : words) {
            int num = key.get(w);
            result = result * 10 + num;
        }
        return result;
    }
}
