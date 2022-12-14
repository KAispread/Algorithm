package Programmers.level0;

import java.util.Arrays;

/*
* 외계어 사전
* */
public class StrangeDic {
    public static void main(String[] args) {

    }

    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);
        String spl = String.join("", spell);
        for (String word : dic) {
            String[] buffer = word.split("");
            Arrays.sort(buffer);
            String wordSpl = String.join("", buffer);
            if (wordSpl.equals(spl)) {
                return 1;
            }
        }
        return 2;
    }
}
