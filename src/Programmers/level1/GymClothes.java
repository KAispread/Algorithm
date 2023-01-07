package Programmers.level1;

/*
* 체육복
* */
public class GymClothes {
    public static void main(String[] args) {
        solution(5, new int[]{2, 4}, new int[] {3});
    }
    static int[] costume;
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        costume = new int[n];

        for (int i = 0; i < costume.length; i++) {
            costume[i]++;
        }

        for (int i = 0; i < lost.length; i++) {
            costume[lost[i] - 1]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            costume[reserve[i] - 1]++;
        }

        for (int i = 0; i < costume.length; i++) {
            if (costume[i] > 1) {
                if (i != 0 && costume[i - 1] < 1) {
                    costume[i]--;
                    costume[i-1]++;
                } else if (i != costume.length - 1 && costume[i + 1] < 1) {
                    costume[i]--;
                    costume[i+1]++;
                }
            }
        }

        for (int c : costume) {
            if (c > 0) {
                answer++;
            }
        }

        return answer;
    }
}
