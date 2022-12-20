package Do_it_Algorithm.numberOfTheory;

import java.util.Scanner;

/*
* 1456번 - Silver I
* 거의 소수
* */
public class Q38Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        long[] answer = new long[10000001];
        for (int i = 2; i < answer.length; i++) {
            answer[i] = i;
        }

        // s
        for (int i = 2; i < Math.sqrt(answer.length); i++) {
            if (answer[i] == 0) {
                continue;
            }

            for (int j = i + i; j < answer.length; j += i) {
                answer[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < answer.length; i++) {
            if (answer[i] != 0) {
                long temp = answer[i];
                while ((double) answer[i] <= (double) max / (double) temp) {
                    if ((double) answer[i] >= (double) min / (double) temp) {
                        count++;
                    }
                    temp *= answer[i];
                }
            }
        }
        System.out.println(count);
    }
}
