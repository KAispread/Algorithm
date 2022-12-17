package Do_it_Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q36Greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String expression = bf.readLine();
        String[] ex = expression.split("-");

        int posi = 0;
        int nega = 0;
        for (int i = 0; i < ex.length; i++) {
            if (i == 0) {
                posi = getSumString(ex[i]);
            }
            String negaExpression = ex[i];
            nega += getSumString(negaExpression);
        }
        System.out.println(posi - nega);
    }

    private static int getSumString(String expression) {
        String[] numbers = expression.split("[+]");
        int sum = 0;
        for (int i =0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}
