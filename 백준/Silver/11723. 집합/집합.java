import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final String ADD = "add";
    static final String REMOVE = "remove";
    static final String CHECK = "check";
    static final String TOGGLE = "toggle";
    static final String ALL = "all";
    static final String EMPTY = "empty";
    static boolean[] group = new boolean[21];

    // Blue 색깔은 미리 계산 후 0으로 초기화 -> 이후 배열 복사 -> 적록색약인 경우, 아닌 경우 따로 BFS Go
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            String command = st.nextToken();

            if (command.equals(ADD)) {
                int number = Integer.parseInt(st.nextToken());
                group[number] = true;

            } else if (command.equals(REMOVE)) {
                int number = Integer.parseInt(st.nextToken());
                group[number] = false;

            } else if (command.equals(CHECK)) {
                int number = Integer.parseInt(st.nextToken());
                if (group[number]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals(TOGGLE)) {
                int number = Integer.parseInt(st.nextToken());
                group[number] = !group[number];

            } else if (command.equals(ALL)) {
                Arrays.fill(group, true);
            } else if (command.equals(EMPTY)) {
                Arrays.fill(group, false);
            }
        }

        System.out.println(sb.toString());
    }

}

