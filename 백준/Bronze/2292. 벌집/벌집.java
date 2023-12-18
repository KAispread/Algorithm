import java.util.Scanner;

public class Main {
    // 몇 번째 Layer 인지만 판단하면 됨
    // 1 layer -> 1 [1개]
    // 2 layer -> 2 ~ 7 [6개]
    // 3 layer -> 8 ~ 19 [12개]
    // 4 layer -> 20 ~ 37 [18개]
    // 5 layer -> 38 ~ 61 [24개]
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int area = 1;
        int count = 1;
        
        while (area < N) {
            count++;
            area += (count - 1) * 6;
        }
        
        System.out.println(count);
    }

}

