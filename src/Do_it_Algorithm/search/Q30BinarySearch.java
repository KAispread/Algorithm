package Do_it_Algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 2343번 - Silver I
* */
public class Q30BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        st = new StringTokenizer(bf.readLine());

        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            if (start < data[i]) {
                start = data[i];
            }
            end += data[i];
        }

        int blueSize = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            int groupSum = 0;
            int blueCount = 1;

            for (int length : data) {
                groupSum += length;
                if (groupSum > middle) {
                    groupSum = length;
                    blueCount++;
                }
            }
            if (blueCount > M) {
                start = middle + 1;
            } else {
                blueSize = middle;
                end = middle - 1;
            }
        }

        System.out.println(blueSize);
    }
}
