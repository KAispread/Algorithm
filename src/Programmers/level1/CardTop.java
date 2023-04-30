package Programmers.level1;

/*
* 카드 뭉치
* */
public class CardTop {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(k<goal.length){
            if(i < cards1.length&&goal[k].equals(cards1[i])){
                k++;
                i++;
            } else if(j < cards2.length&&goal[k].equals(cards2[j])){
                k++;
                j++;
            } else break;
        }

        return k==goal.length ? "Yes" : "No";
    }
}
