import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    //
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String current = bf.readLine();
            set.add(current);
        }

        List<String> dictionary = new ArrayList<>(set);
        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });

        for (String s : dictionary) {
            System.out.println(s);
        }
    }


}

