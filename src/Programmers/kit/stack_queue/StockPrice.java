package Programmers.kit.stack_queue;

// LEVEL2 -> 주식 가격
public class StockPrice {

    static class Try {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length; i++) {
                int current = prices[i];

                for (int j = i + 1; j < prices.length; j++) {
                    answer[i]++;

                    if (prices[i] > prices[j]) break;
                }
            }

            return answer;
        }
    }

    static class Answer {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for(int i = 0; i < answer.length; i++) {
                for(int j = i + 1; j < answer.length; j++) {
                    answer[i]++;

                    if(prices[i] > prices[j]) break;
                }
            }

            return answer;
        }
    }
}
