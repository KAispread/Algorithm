class Solution {
    
    private static final int[][] moving = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int solution(String[][] board, int h, int w) {
        final String pivot = board[h][w];
        int MAX_H = board.length;
        int MAX_W = board[0].length;
        int answer = 0;
        
        for (int[] move : moving) {
            int th = h + move[0];
            int tw = w + move[1];
            
            if (th < 0 || th >= MAX_H || tw < 0 || tw >= MAX_W) continue;
            if (pivot.equals(board[th][tw])) answer++;
        }
        
        
        return answer;
    }
}