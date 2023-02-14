package Programmers.level2;

import java.util.Arrays;

/*
* 최댓값과 최솟값
* */
public class MinMaxNumber {
    public String solution(String s) {
        String[] nums = s.split(" ");
        Arrays.sort(nums, (o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
        return nums[0]+" "+nums[nums.length - 1];
    }
}
