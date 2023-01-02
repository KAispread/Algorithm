package Programmers.level2;

/*
* K진수에서 소수구하기
* */
public class PrimeInK {
    public static void main(String[] args) {
        System.out.println(solution(1, 8));
    }

    public static int solution(int n, int k) {
        int index = 0;
        int pow = 1;

        while (pow <= n) {
            index++;
            pow *= k;
        }
        index--;

        StringBuilder builder = new StringBuilder();
        int total = n;
        for (int i = index; i >= 0; i--) {
            if (total == 0) {
                builder.append(0);
                continue;
            }
            if (i == 0) {
                builder.append(total / 1);
                break;
            }
            int num = total / pows(i, k);
            total -= pows(i, k) * num;
            builder.append(num);
        }

        String[] target = builder.toString().split("0");
        int answer = 0;
        for (String tar : target) {
            if (tar.equals("1")) {
                continue;
            }
            if (!tar.isBlank() && isPrime(Integer.parseInt(tar))) {
                answer++;
            }
        }

        return answer;
    }

    private static int pows(int index, int k) {
        int a = 1;
        for (int i = 0 ; i < index; i++) {
            a *= k;
        }
        return a;
    }

    private static boolean isPrime(int k) {
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
