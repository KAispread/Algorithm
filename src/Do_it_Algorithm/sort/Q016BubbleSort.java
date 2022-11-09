package Do_it_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 백준 - 1377번 Gold III
 *
 * */
public class Q016BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Data[] A = new Data[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Data(Integer.parseInt(bf.readLine()), i);
        }

        Arrays.sort(A);

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }

        System.out.println(max + 1);
    }
}

class Data implements Comparable<Data> {
    int value;
    int index;

    public Data(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) {
        return this.value - o.value;
    }
}
