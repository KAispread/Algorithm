package commuLearning.week1.step1;

/*
* 기지국 설치
* 해결 여부 - X
* */
public class InstallTop {
    private int[] reached;
    private boolean[] locate;
    private int N;

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        reached = new int[n+1];
        locate = new boolean[n+1];
        N = n;

        for (int count = 0; count < stations.length; count++) {
            int a = stations[count];

            markReached(a, w);
        }

        int index = 0;
        int count = 0;

        while (index <= n) {
            if (reached[index] == 0) {
                boolean flag = false;
                for (int i = 1; i <= w; i++) {
                    int a = index + i;

                    if (a <= n && reached[a] > 0) {
                        markReached(a - 1, w);
                        count++;
                        index = a - 1 + w;
                        flag = true;
                        break;
                    } else if (a == n) {
                        markReached(a, w);
                        count++;
                        index = a + w;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    markReached(index + w, w);
                    count++;
                }
            }

            index++;
        }

        return count;
    }

    private void markReached(int pivot, int w) {
        reached[pivot]++;
        locate[pivot] = true;

        for (int i = 0; i < w; i++) {
            if (pivot - (1 + i) >= 0) {
                reached[pivot - (1 + i)]++;
            }
            if (pivot + (1 + i) <= N) {
                reached[pivot + (1 + i)]++;
            }
        }
    }
}
