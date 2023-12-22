import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> removedButtonList = new ArrayList<>();
    private static int answer = 999_999;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(bf.readLine());
        int number = Integer.parseInt(bf.readLine());

        if (number > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < number; i++) {
                removedButtonList.add(Integer.parseInt(st.nextToken()));
            }
        }

        answer = Math.abs(100 - target);

        for (int i = 0; i <= 999_999; i++) {
            String numberStr = String.valueOf(i);
            boolean flag = false;

            for (int n = 0; n < numberStr.length(); n++) {
                if (removedButtonList.contains(numberStr.charAt(n) - '0')) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            int numberCount = numberStr.length();
            answer = Math.min(Math.abs(i - target) + numberCount, answer);
        }
        System.out.println(answer);
    }

}

