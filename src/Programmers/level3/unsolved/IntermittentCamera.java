package Programmers.level3.unsolved;

import java.util.Arrays;

/*
* 단속 카메라
* */
public class IntermittentCamera {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        int answer = 0;

        // 진출 지점을 최소 진입시점으로 저장
        // 진입 시점이 min보다 크면 겹치지 않는 구간이므로 카운트
        int min = -30000;
        for (int i = 0; i < routes.length; i++) {
            if (min < routes[i][0]) {
                min = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
