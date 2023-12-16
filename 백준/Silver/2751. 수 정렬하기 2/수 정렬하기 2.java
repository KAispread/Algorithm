import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number  = Integer.parseInt(bf.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(list, Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();

        for (int i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

}

