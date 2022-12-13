package Programmers.level0;

/*
* 저주의 숫자 3
* */
public class CurseNumber3 {
    public static void main(String[] args) {

    }

    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count++;
            while (isMultipleThree(count) || isContainThree(count)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMultipleThree(int num) {
        if (num % 3 == 0) {
            return true;
        }
        return false;
    }

    private boolean isContainThree(int num) {
        String[] split = String.valueOf(num).split("");
        for (String n : split) {
            if (n.equals("3")) {
                return true;
            }
        }
        return false;
    }
}
