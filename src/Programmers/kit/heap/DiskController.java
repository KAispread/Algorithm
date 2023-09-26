package Programmers.kit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// LEVEL3 - 디스크 컨트롤러
public class DiskController {

    static class Try {
        public int solution(int[][] jobs) {
            Queue<Job> jobQueue = new PriorityQueue<>((o1, o2) -> o1.workTime - o2.workTime);

            List<Job> jobList = new ArrayList<>();
            for (int[] job : jobs) {
                jobList.add(new Job(job[0], job[1]));
            }
            jobList.sort((o1, o2) -> o1.entryTime - o2.entryTime);

            int time = 0;
            int result = 0;
            int listIndex = 0;

            while (listIndex < jobList.size() || !jobQueue.isEmpty()) {
                listIndex = addJobToQueue(time,listIndex, jobQueue, jobList);

                if (jobQueue.isEmpty()) {
                    time = jobList.get(listIndex).entryTime;
                    listIndex = addJobToQueue(time, listIndex, jobQueue, jobList);
                }

                final Job job = jobQueue.poll();
                time += job.workTime;
                result += time - job.entryTime;
            }

            return (int) Math.floor(result / jobList.size());
        }

        public int addJobToQueue(int time, int listIndex, Queue<Job> jobQueue, List<Job> jobList) {
            while (listIndex < jobList.size() && time >= jobList.get(listIndex).entryTime) {
                Job job = jobList.get(listIndex);
                jobQueue.offer(job);
                listIndex++;
            }

            return listIndex;
        }

        class Job {
            int entryTime;
            int workTime;

            public Job(int entryTime, int workTime) {
                this.entryTime = entryTime;
                this.workTime = workTime;
            }
        }
    }

    static class Answer {
        public int solution(int[][] jobs) {
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
}
