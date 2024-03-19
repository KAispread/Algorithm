import java.util.*;

class Solution {

    static int[][] globalDice;
    static int diceCount = 0;
    static int max = 0;
    static int[] answer;
    
    public int[] solution(int[][] dice) {
        globalDice = dice;
        diceCount = dice.length / 2;
        answer = new int[diceCount];
        
        selectDice(new int[diceCount], 0, 0);
        
        return answer;
    }
    
    // dice를 선택한다.
    private void selectDice(int[] aDice, int index, int start) {
        if (index == diceCount) {
            int[] bDice = getBDice(aDice);
            calculate(aDice, bDice);
            return;
        }
        
        for (int i = start; i < globalDice.length; i++) {
            aDice[index] = i;
            selectDice(aDice, index + 1, i + 1);
        }
    }
    
    private int[] getBDice(int[] aDice) {
        int[] bDice = new int[diceCount];
        int index = 0;
        
        for (int i = 0; i < globalDice.length; i++) {
            boolean isADice = false;
            for (int j = 0; j < aDice.length; j++) {
                if (aDice[j] == i) {
                    isADice = true;
                    break;
                }
            }
            
            if (!isADice) {
                bDice[index] = i;
                index++;
            }
        }
        
        return bDice;
    }
    
    // 선택한 dice 에서 나올 수 있는 경우의 수를 구하고 최댓값과 비교한다.
    private void calculate(int[] aDice, int[] bDice) {
        List<Integer> scoreA = new ArrayList<>();
        List<Integer> scoreB = new ArrayList<>();
        
        getPossibleScores(aDice, scoreA, 0, 0);
        getPossibleScores(bDice, scoreB, 0, 0);
        
        Collections.sort(scoreA);
        Collections.sort(scoreB);
        int count = 0;
        
        for (int a = 0; a < scoreA.size(); a++) {
            int aScore = scoreA.get(a);
            
            for (int b = 0; b < scoreB.size(); b++) {
                if (aScore > scoreB.get(b)) count++;
                else break;
            }
        }
        
        if (count > max) {
            max = count;
            
            for (int a = 0; a < aDice.length; a++) {
                answer[a] = aDice[a] + 1;
            }
        }
    }
    
    // 선택한 주사위 조합에서 나올 수 있는 경우의 수를 반환한다.
    private void getPossibleScores(int[] dice, List<Integer> scores, int sum, int depth) {
        if (depth == diceCount) {
            scores.add(sum);
            return;
        }
        
        int diceNum = dice[depth];
        for (int score : globalDice[diceNum]) {
            getPossibleScores(dice, scores, sum + score, depth + 1);
        }
        
    }
}