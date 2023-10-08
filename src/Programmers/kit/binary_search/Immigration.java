package Programmers.kit.binary_search;

import java.util.stream.IntStream;

// LEVEL 3 - 입국심사
public class Immigration {

    public long solution(int n, int[] times) {
        long min = 0;
        long max = (long) (IntStream.of(times).max().orElse(0)) * n;
        long answer = max;

        System.out.println("min :: " + min + " max :: " + max + " // " + 3/5);

        while (min <= max) {
            long sum = 0;
            long mid = (max + min) / 2;

            for (int t : times) {
                sum += mid / t;
            }

            if (sum >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
}
