import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int answer = 0;
        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());
            if (isPrime(current)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        double sqrt = Math.sqrt(number);

        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}

