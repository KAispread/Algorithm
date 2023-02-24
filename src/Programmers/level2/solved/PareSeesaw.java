package Programmers.level2.solved;

import java.util.ArrayList;
import java.util.List;

public class PareSeesaw {
    public static void main(String[] args) {
        solution(new int[] {100,180,360,100,270});
    }
    public static long solution(int[] weights) {
        long answer = 0;
        List<Integer> N = new ArrayList<>();

        for (int w : weights) {
            N.add(w);
            N.add(w / 2);
            N.add(w / 3);
            N.add(w / 4);
        }

        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            boolean flag = false;
            N.remove((Object) w);
            N.remove((Object) (w / 2));
            N.remove((Object) (w / 3));
            N.remove((Object) (w / 4));

            for (int k = 0; k < 4; k++) {
                int kw = w / (k + 1);
                if (N.contains(kw)) flag = true;
                N.add(kw);
            }
            if (flag) count++;
        }

        return answer;
    }

}
