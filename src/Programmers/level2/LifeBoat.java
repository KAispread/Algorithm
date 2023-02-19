package Programmers.level2;

import java.util.Arrays;

/*
* 구명 보트
* */
public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int front = 0;
        int back = people.length - 1;

        while (front < back) {
            if (people[front] + people[back] <= limit) front++;
            back--;
            answer++;
        }

        if (front == back) answer++;

        return answer;
    }
}
