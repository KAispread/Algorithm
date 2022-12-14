package Do_it_Algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
* 1920번 - Silver IV
* */
public class Q29BinarySearch {
    static List<Integer> pivot = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int given = Integer.parseInt(st.nextToken());
            boolean find = false;

            int start = 0;
            int end = data.length - 1;

            while (start <= end) {
                if (data[start] == given || data[end] == given) {
                    find = true;
                    break;
                }

                int mid = (start + end) / 2;
                int midValue = data[mid];
                if (midValue > given) {
                    start++;
                    end = mid - 1;
                } else if (midValue < given) {
                    start = mid + 1;
                } else {
                    find= true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static void binarySearch(int[] data, int key, int start, int end) {
        if (start == key || end == key) {
            System.out.println(1);
            return;
        }
        int middle = (start + end) / 2;
        if (pivot.contains(middle) || start == end) {
            System.out.println(0);
            return;
        }
        pivot.add(middle);
        if (middle > key && start <= key) {
            binarySearch(data, key, start, middle);
        } else if(middle < key && end >= key ) {
            binarySearch(data, key, middle, end);
        }
    }
}
