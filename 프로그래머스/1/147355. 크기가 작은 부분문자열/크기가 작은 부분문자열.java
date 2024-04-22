class Solution {
    public int solution(String t, String p) {
        int tl = t.length();
        int pl = p.length();
        int answer = 0;
        
        for (int i = 0; i < tl - pl + 1; i++) {
            if (0 >= t.substring(i, i + pl).compareTo(p)) {
                answer++;        
            }
        }

        return answer;
    }
}