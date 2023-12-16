import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    // 666 을 기준으로 카운팅
    // 1666, 2666 / 666 앞에 숫자가 오는 경우의 수 9가지 + 6660, 6661 / 10가지 => 4자리수 19가지
    // 10666, 11666, 12666 ... 90개 + 66600, 66601 .. / 100가지 + 190개
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        if (N == 1) {
            System.out.println(666);
            return;
        }
        
        int count = 1;
        int current = 1665;
        while (true) {
            current++;
            if (String.valueOf(current).contains("666")) count++;
            if (count == N) {
                System.out.println(current);
                break;
            }
        }
    }
}

