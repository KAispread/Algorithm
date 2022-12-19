package Programmers.level1;

/*
* 소수 만들기
* - 3 Pointer 로 index 를 늘려가며 해결
* */
public class MakePrime {
    public static void main(String[] args) {
        solution(new int[] {1,2,7,6,4});
    }

    public static int solution(int[] nums) {
        int x = 0;
        int y = 1;
        int z = 2;
        int maxIndex = nums.length;
        int cnt = 0;

        while (z < maxIndex
                && y < maxIndex - 1
                && x < maxIndex - 2) {
            if (isPrime(nums[x] + nums[y] + nums[z])) {
                cnt++;
            }
            if (z < maxIndex - 1) {
                z++;
                continue;
            } else if (y < maxIndex - 2) {
                y++;
                z = y + 1;
                continue;
            } else if (x < maxIndex - 3) {
                x++;
                y = x + 1;
                z = y + 1;
                continue;
            }
            break;
        }

        return cnt;
    }

    private static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                if (i * i < num) {
                    count++;
                }
            }
        }
        if (count <= 2) {
            return true;
        }
        return false;
    }
}
