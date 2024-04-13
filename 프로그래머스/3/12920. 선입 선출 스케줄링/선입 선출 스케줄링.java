class Solution {
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