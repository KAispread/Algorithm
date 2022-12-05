package Programmers.level0;

import java.util.HashSet;
import java.util.Set;

/*
* 약수 구하기
* */
public class PrintFactor {
    public static void main(String[] args) {

    }

    public int[] solution(int n) {
        Set<Integer> answer = new HashSet<>();
        for (int count =1; count < n /2 + 1; count++) {
            if (n % count == 0) {
                int num = n / count;
                answer.add(count);
                answer.add(num);
            }
        }
        return answer.stream().sorted().mapToInt(num -> (int) num).toArray();
    }
}
