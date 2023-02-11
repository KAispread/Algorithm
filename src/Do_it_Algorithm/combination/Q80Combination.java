package Do_it_Algorithm.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 13251번 - 조약돌 꺼내기
* */
public class Q80Combination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        List<Integer> number = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            number.add(num);
            total += num;
        }

        int K = sc.nextInt();
        double rate = 0.0;

        for (Integer num : number) {
            if (num >= K) {
                double prob = 1.0;
                for (int i = 0; i < K; i++) {
                    prob *= (double) (num - i) / (total - i);
                }
                rate += prob;
            }
        }

        System.out.println(rate);
    }
}
