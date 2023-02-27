package Programmers.level2;

/*
게임이 비 정상적인 경우
1. O의 개수가 X보다 1 많거나 같지 않을 때
2. 게임이 종료되었는데도 계속 진행되었을 때
- O의 승리 -> O가 X보다 1 많아야함
- X의 승리 -> X가 O의 개수와 똑같아야함
- 둘 다 이겼을 경우

O의 개수
X의 개수

*/
// 혼자서 하는 틱택토
public class TicTacTo {
    class Solution {
        public int solution(String[] board) {
            int firstCount = getCount(board, 'O');
            int secondCount = getCount(board, 'X');
            int[] cnt = new int[] {firstCount, secondCount};

            boolean firstWin = isWin(board, 'O');
            boolean secondWin = isWin(board, 'X');
            boolean[] winner = new boolean[] {firstWin, secondWin};

            int answer = 0;
            if (validate(cnt, winner)) answer = 1;
            return answer;
        }

        private boolean isWin(String[] board, char mark) {
            for (int i = 0; i < board.length; i++) {
                boolean rowFlag = true;
                for (int row = 0; row < board[0].length(); row++) {
                    if (board[i].charAt(row) != mark) {
                        rowFlag = false;
                        break;
                    }
                }

                boolean colFlag = true;
                for (int col = 0; col < board.length; col++) {
                    if (board[col].charAt(i) != mark) {
                        colFlag = false;
                        break;
                    }
                }

                if (rowFlag || colFlag) return true;
            }

            // 대각선
            if (board[0].charAt(0) == mark && board[1].charAt(1) == mark
                    && board[2].charAt(2) == mark) return true;
            if (board[0].charAt(2) == mark && board[1].charAt(1) == mark
                    && board[2].charAt(0) == mark) return true;
            return false;
        }

        private int getCount(String[] board, char mark) {
            int cnt = 0;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length(); col++) {
                    if (board[row].charAt(col) == mark) cnt++;
                }
            }

            return cnt;
        }

        private boolean validate(int[] cnt, boolean[] winner) {
            if (winner[0] && winner[1]) {
                return false;
            }
            if (winner[0] && cnt[0] - cnt[1] != 1) {
                return false;
            }
            if (winner[1] && cnt[0] != cnt[1]) {
                return false;
            }
            if (cnt[0] - cnt[1] > 1 || cnt[0] - cnt[1] < 0) {
                return false;
            }
            return true;
        }
    }
}
