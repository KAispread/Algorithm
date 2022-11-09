package Do_it_Algorithm.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
백준 - 12891 Silver V

* *Feat

- 슬라이딩 윈도우 프로토콜 사용
- P의 크기만큼 투포인터의 거리를 설정.
- 최초 연산시 결과를 배열에 저장 ('A', 'C', 'G', 'T' )
- DNA 문자열 끝까지 투포인터를 이동, 이 때 기존 문자열에서 제외되는 문자와
  추가되는 문자를 결과값을 저장하는 배열에 -, + 연산
* */
public class Q009SlidingWindow {
    public static final char[] DNA_CHAR = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        final String DNA = st.nextToken();

        st = new StringTokenizer(bf.readLine());
        int[] limits = new int[DNA_CHAR.length];
        for (int i =0; i< limits.length; i++) {
            limits[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] contains = new int[DNA_CHAR.length];

        for (int i = P; i < S + 1; i++) {
            int first = i - P;
            if (i == P) {
                String curDna = DNA.substring(first, i);
                for (int j = 0; j < curDna.length(); j++) {
                    char c = curDna.charAt(j);
                    for (int a = 0; a < DNA_CHAR.length; a++) {
                        if (c == DNA_CHAR[a]) contains[a] += 1;
                    }
                }
            } else {
                for (int j = 0; j < DNA_CHAR.length; j++) {
                    if (DNA.charAt(first - 1) == DNA_CHAR[j]) contains[j] -= 1;
                }
                for (int j = 0; j < DNA_CHAR.length; j++) {
                    if (DNA.charAt(i - 1) == DNA_CHAR[j]) contains[j] += 1;
                }
            }
            System.out.println("contains = " + Arrays.toString(contains));
            int count = 0;
            for (int j = 0; j < contains.length; j++) {
                if (limits[j] <= contains[j]) {
                    count++;
                }
            }
            if (count == 4) answer++;
        }
        System.out.println(answer);
    }
}
