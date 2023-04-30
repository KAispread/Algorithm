package Programmers.level1;

import java.util.Arrays;

/*
* 추억 점수
* */
public class MemorableScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(Arrays.asList(name).contains(photo[i][j])){
                    answer[i] += yearning[Arrays.asList(name).indexOf(photo[i][j])];
                }
            }
        }

        return answer;
    }
}
