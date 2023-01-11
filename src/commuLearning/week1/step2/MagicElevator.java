package commuLearning.week1.step2;

/*
* 마법의 엘리베이터
* 해결 여부 - O
* */
public class MagicElevator {
    public int solution(int storey) {
        int answer = 0;

        int len = String.valueOf(storey).length();
        String[] nums = String.valueOf(storey).split("");
        boolean upper = false;

        for (int cnt = nums.length - 1; cnt >= 0; cnt--) {
            int n = Integer.parseInt(nums[cnt]);
            if (upper) {
                n++;
            }

            if (n == 5) {
                answer += n;
                if (cnt > 0 && Integer.parseInt(nums[cnt-1]) >= 5) {
                    upper = true;
                } else {
                    upper = false;
                }
            } else if (n == 10){
                upper = true;
            } else if (n < 5) {
                upper = false;
                answer += n;
            } else if (n > 5) {
                upper = true;
                answer += 10 - n;
            }

            System.out.println("answer = " + answer);
        }
        if (upper) answer++;
        return answer;
    }
}
