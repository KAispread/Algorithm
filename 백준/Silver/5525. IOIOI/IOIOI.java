import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        char[] charArray = bf.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'I' && isPn(i, charArray)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean isPn(int startIdx, char[] charArray) {
        boolean toBeI = true;
        int oCount = 0;

        for (int i = startIdx; i < charArray.length; i++) {
            if ((toBeI && charArray[i] != 'I') || (!toBeI && charArray[i] == 'I')) return false;

            if (charArray[i] == 'I') {
                if (oCount == N) return true;
                toBeI = false;
            } else {
                oCount++;
                toBeI = true;
            }
        }

        return false;
    }
}

