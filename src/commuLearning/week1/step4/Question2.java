package commuLearning.week1.step4;

import java.util.Arrays;

/*
* 동전 뒤집기
* while 루프를 돌면서 시뮬레이션
* */
public class Question2 {
    public int solution(int[] coin, int k) {
        int[] exf = Arrays.copyOf(coin, coin.length);
        int caseF = makeCoin(exf, 1, k);

        int[] exb = Arrays.copyOf(coin, coin.length);
        int caseB = makeCoin(exb, 0, k);

        if (caseF == Integer.MAX_VALUE &&
                caseB == Integer.MAX_VALUE) {
            return -1;
        }

        return Math.min(caseF, caseB);
    }

    private int makeCoin(int[] coin, int v, int k) {
        int idx = 0;
        int count = 0;
        while (idx < coin.length) {
            if (coin[idx] == v) {
                idx++;
            } else {
                if (idx + k > coin.length) {
                    break;
                }
                for (int i = 0; i < k; i++) {
                    if (coin[idx + i] == 0) {
                        coin[idx + i] = 1;
                    } else {
                        coin[idx + i] = 0;
                    }
                }
                count++;
                idx++;
            }
        }

        if (!isMade(coin)) {
            count = Integer.MAX_VALUE;
        }

        return count;
    }

    private boolean isMade(int[] coin) {
        final int pivot = coin[0];
        for (int c : coin) {
            if (c != pivot) {
                return false;
            }
        }
        return true;
    }
}
