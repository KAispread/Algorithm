import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Integer> mbtiMap = new HashMap<>();
    static List<String> mbtiList = List.of("ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ");
    static int answer;

    // N이 아무리 많아도 결국 MBTI는 16개
    // 3가지 MBTI 경우의 수는 16^3 임 = 2500 ~ 3000 개 정도
    // Map에 각 MBTI 별 개수를 저장해놓고 DFS로 풀어낼 수 있을듯?
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            answer = Integer.MAX_VALUE;

            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++) {
                String mbti = st.nextToken();
                mbtiMap.put(mbti, mbtiMap.getOrDefault(mbti, 0) + 1);
            }

            mbtiDFS(0, new ArrayList<>());

            System.out.println(answer);
            mbtiMap.clear();
        }
    }

    private static void mbtiDFS(int depth, List<String> mbti) {
        if (depth == 3) {
            int amount = updateAnswer(mbti);
            answer = Math.min(amount, answer);
            return;
        }

        for (String m : mbtiList) {
            int cnt = mbtiMap.getOrDefault(m, 0);
            if (cnt < 1) continue;

            mbtiMap.put(m, cnt - 1);
            mbti.add(m);
            mbtiDFS(depth + 1, mbti);
            mbti.remove(m);
            mbtiMap.put(m, cnt);
        }
    }

    private static int updateAnswer(List<String> mbti) {
        String a = mbti.get(0);
        String b = mbti.get(1);
        String c = mbti.get(2);

        return getLengthAmongTwoMbti(a, b) + getLengthAmongTwoMbti(b, c) + getLengthAmongTwoMbti(a, c);
    }

    private static int getLengthAmongTwoMbti(String mbtiA, String mbtiB) {
        char[] aChar = mbtiA.toCharArray();
        char[] bChar = mbtiB.toCharArray();
        int count = 0;

        for (int i = 0; i < 4; i++) {
            if (aChar[i] != bChar[i]) {
                count++;
            }
        }

        return count;
    }
}

