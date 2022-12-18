package Programmers.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
* 옹알이 2
* */
public class Babble2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }

    public static int solution(int[] ingredient) {
        String collect = Arrays.stream(ingredient).boxed().map(String::valueOf).collect(Collectors.joining());
        boolean flag = true;
        int count = 0;
        while (collect.length() >= 4 && flag) {
            int before = collect.length();
            collect = collect.replaceFirst("1231", "");
            if (before != collect.length()) {
                count++;
                flag = false;
            }
        }
        return count;
    }
}
