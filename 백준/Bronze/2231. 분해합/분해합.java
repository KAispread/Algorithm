import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i < 1_000_000; i++) {
            String is = String.valueOf(i);

            int sum = i;
            for (int j = 0; j < is.length(); j++) {
                int current = is.charAt(j) - '0';
                sum += current;
            }

            if (sum == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

}

