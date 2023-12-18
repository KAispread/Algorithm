import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int up = sc.nextInt();
        int down = sc.nextInt();
        int point = sc.nextInt();

        point = point -= up;

        int sprint = up - down;
        int day = point / sprint;
        if (point % sprint != 0) day++;

        System.out.println(day + 1);
    }

}

