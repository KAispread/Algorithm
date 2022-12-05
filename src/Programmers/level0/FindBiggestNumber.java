package Programmers.level0;

import java.util.Arrays;

/*
* 가장 큰 수 찾기
* */
public class FindBiggestNumber {
    public static void main(String[] args) {
        int[] asb = {0, 1, 2, 4, 4, 4, 4, 4, 5};

        // 배열에서 특정 인덱스를 찾음
        int index = Arrays.binarySearch(asb, 8);

        System.out.println(index);
    }

    public int[] solution(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int index = Arrays.binarySearch(array, max);
        return new int[] {max, index};
    }
}
