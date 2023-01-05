package Programmers.level2;

import java.util.ArrayList;
import java.util.List;

/*
* 카펫
* */
public class Carpet {
    public static void main(String[] args) {
        solution(10, 2);
    }

    static List<int[]> divisor = new ArrayList<>();
    public static int[] solution(int brown, int yellow) {
        divide(yellow);
        int[] answer = new int[2];
        for (int[] div : divisor) {
            int b = ((div[0] + 2) * 2) + ((div[1] + 2) * 2) - 4;
            if (b == brown) {
                answer[1] = div[0] + 2;
                answer[0] = div[1] + 2;
                break;
            }
        }

        return answer;
    }

    private static void divide(int num) {
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                divisor.add(new int[] {i, num / i});
            }
        }
    }
}
