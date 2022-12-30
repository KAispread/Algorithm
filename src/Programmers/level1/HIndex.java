package Programmers.level1;

import java.util.Arrays;

/*
* H-Index
* 1 - 배열 요소의 값이 남은 배열 길이와 같은 경우 => 요소값 return
* 2 - 배열 요소의 값이 남은 배열 길이보다 큰 경우 => 배열 길이 return
* 3 - 배열 요소의 값이 남은 배열 길이보다 작은 경우 => 요소 값 저장 후 answer return
* */
public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for (int i = 0; i < citations.length; i ++) {
            if (citations.length - i <= citations[i]) {
                answer = citations.length - i;
                break;
            } else if (citations.length - i >= citations[i]) {
                answer = citations[i];
            }
        }
        return answer;
    }
}
