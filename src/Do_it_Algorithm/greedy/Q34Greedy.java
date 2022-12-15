package Do_it_Algorithm.greedy;

import java.util.*;

/*
* 1744 - Gold IV
* */
public class Q34Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }
        Queue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> negative = new PriorityQueue<>();

        boolean zero = false;
        int one = 0;
        List<Integer> addNumber = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            if (number[i] < 0) {
                negative.add(number[i]);
            } else if (number[i] > 1) {
                positive.add(number[i]);
            } else if (number[i] == 1) {
                one++;
            } else {
                zero = true;
            }
        }


        while (negative.size() > 1) {
            int negaA = negative.remove();
            int negaB = negative.remove();
            addNumber.add(negaA * negaB);
        }

        if (!negative.isEmpty() && !zero) {
             addNumber.add(negative.remove());
        }

        while (positive.size() > 1) {
            int posiA = positive.remove();
            int posiB = positive.remove();
            addNumber.add(posiA * posiB);
        }
        if (!positive.isEmpty()) {
            addNumber.add(positive.remove());
        }
        int sum = 0;
        for (Integer num : addNumber) {
            sum += num;
        }
        sum += one;
        System.out.println(sum);
    }


}
