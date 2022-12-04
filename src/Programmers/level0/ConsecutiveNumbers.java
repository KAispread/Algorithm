package Programmers.level0;

import java.util.Arrays;

public class ConsecutiveNumbers {
    public static void main(String[] args) {
        solution(3, 12);
    }

    public static int[] solution(int num, int total) {
        int[] answer = new int[num];
        int count = 1;
        int sum = 0;
        for (int i =0; i< answer.length; i++) {
            answer[i] = count;
            sum += answer[i];
            count++;
        }
        int gap = total - sum;
        if (gap > 0) {
            positive(answer, gap);
        } else if (gap < 0) {
            negative(answer, Math.abs(gap));
        }
        return answer;
    }

    private static void positive(int[] numbers, int gap) {
        while (gap > 0) {
            for (int i = numbers.length - 1; i >= 0; i--) {
                numbers[i] += 1;
                gap--;
                if (gap <= 0) {
                    break;
                }
            }
        }
    }

    private static void negative(int[] numbers, int gap) {
        while (gap > 0) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] -= 1;
                gap--;
                if (gap <= 0) {
                    break;
                }
            }
        }
    }
}

