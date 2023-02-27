package Programmers.level3.unsolved;

public class CPUCores {
    // 시간 초과
    private int[] process;

    public int solution(int n, int[] cores) {
        process = new int[cores.length];

        int answer = 0;

        while (n > 0) {
            for (int i = 0; i < process.length; i++) {
                if (process[i] == 0) {
                    n--;
                    if (n == 0) {
                        answer = i + 1;
                    }
                }
                process[i]++;

                if (process[i] == cores[i]) {
                    process[i] = 0;
                }
            }
        }

        return answer;
    }

    static class Answer {
        public int solution(int n, int[] cores) {
            int max = n * 10000;
            int min = 0;

            int time = 0;
            int m = 0;

            // time : 마지막 작업이 시작되는 시점을 구함
            while (min <= max) {
                int mid = (min + max) / 2;
                int count = calculate(mid, cores);

                if (count >= n) {
                    max = mid - 1;
                    time = mid;
                    m = count;
                } else {
                    min = mid + 1;
                }
            }

            // n보다 추가로 처리한 작업량
            int remain = m - n;
            int answer = 0;

            for (int i = cores.length - 1; i >= 0; i--) {
                if (time % cores[i] == 0) {
                    if (remain == 0) {
                        answer = i + 1;
                        break;
                    }
                    remain--;
                }
            }

            return answer;
        }

        private int calculate(int time, int[] cores) {
            if (time == 0) {
                return cores.length;
            }

            int count = cores.length;
            for (int c : cores) {
                count += (time / c);
            }
            return count;
        }
    }
}
