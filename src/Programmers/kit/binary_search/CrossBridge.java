package Programmers.kit.binary_search;

import java.util.Arrays;

// LEVEL 4 - 징검다리
public class CrossBridge {

    /*
    rocks 를 오름차순 정렬
    이분 탐색 핵심 - mid 정하기, left/right 옮기는 기준 정하기

    mid - 거리의 최솟값이라고 가정
    Left 옮기는 기준 - 제거한 바위의 수가 n보다 작거나 같을 때
        (why? -> 바위를 적게 옮기고도 주어진 최솟값을 만들 수 있으니 바위를 더 옮기면 더 큰 최솟값을 만들 수 있기 때문)
    Right 옮기는 기준 - 제거한 바위의 수가 n보다 클 때
        (why? -> 바위를 많이 옮겨야 주어진 최솟값을 만들 수 있으니 바위를 적게 옮기면 최솟값이 더 작아지기 때문)
    */
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 0;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int removed = 0;
            int start = 0;

            for (int rock : rocks) {
                int dist = Math.abs(rock - start);
                if (dist < mid) {
                    removed++;
                    continue;
                }

                start = rock;
            }

            // 마지막 바위에서 도착지점까지의 최솟값
            if (distance - start < mid) {
                removed++;
            }

            if (removed > n) {
                right = mid - 1;
                continue;
            }

            answer = Math.max(answer, mid);
            left = mid + 1;
        }

        return answer;
    }
}
