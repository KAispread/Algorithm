package Programmers.level0;

/*
* 모음 제거
* */
public class RemoveVowel {
    class Solution {
        public String solution(String my_string) {
            return my_string.replaceAll("[a|e|i|o|u]", "");
        }
    }
}
