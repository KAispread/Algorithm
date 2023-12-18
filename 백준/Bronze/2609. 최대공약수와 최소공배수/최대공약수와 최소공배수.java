import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int gcd = gcd(Math.max(A, B), Math.min(A, B));
        int lcm = A * B / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int gcd(int a, int b) {
        int remain = a % b;
        if (remain == 0) return b;
        return gcd(b, remain);
    }

}

