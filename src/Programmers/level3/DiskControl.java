package Programmers.level3;

import java.util.*;

/*
* 디스크 컨트롤
* */
public class DiskControl {
    public static void main(String[] args) {
        solution(new int[][] {{0, 3}, {1, 9}, {2, 6}});
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> jobQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int time = 0;
        int count = 0;
        int answer = 0;
        int index = 0;

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                jobQueue.add(jobs[index]);
                index++;
            }

            if (jobQueue.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] poll = jobQueue.poll();
                answer += time - poll[0] + poll[1];
                time += poll[1];
                count++;
            }
        }

        return (int) Math.floor(answer / jobs.length);
    }
}
