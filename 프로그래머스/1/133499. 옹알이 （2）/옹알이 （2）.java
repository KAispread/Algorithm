class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        for (String babble : babbling) {
            if (!babble.replaceAll("ayaaya|yeye|woowoo|mama", "").equals(babble)) {
                continue;
            }
            if (babble.replaceAll("aya|ye|woo|ma", "").isBlank()) {
                count++;
            }
        }
        return count;
    }
}