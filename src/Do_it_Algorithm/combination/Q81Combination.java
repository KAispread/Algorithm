package Do_it_Algorithm.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 1722번 - 순열의 순서 구하기
* */
public class Q81Combination {
    static int[] fac;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fac = new int[N];

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int mul = 2;
        fac[fac.length - 1] = 1;
        for (int i = fac.length - 2; i >= 0; i--) {
            fac[i] = fac[i + 1] * mul;
            mul++;
        }

        System.out.println(Arrays.toString(fac));

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int flag = sc.nextInt();
        if (flag == 1) {
            int K = sc.nextInt();
            System.out.println(numArrayK(K, arr));
        } else {
            int[] S = new int[N];
            for (int i = 0; i < N; i++) {
                S[i] = sc.nextInt();
            }
            System.out.println(getSequence(S, arr));
        }
    }

    private static String numArrayK(int k, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while (idx < fac.length) {
            int add;
            if (fac[idx] >= k) {
                add = getNLineNumber(arr, 1);
                k = k % fac[idx];
            } else if (k % fac[idx] == 0) {
                add = getNLineNumber(arr,k / fac[idx]);
                k = 0;
            } else if (k == 0) {
                add = getNLineNumber(arr,Integer.MAX_VALUE);
            } else {
                add = getNLineNumber(arr,k / fac[idx] + 1);
                k = k % fac[idx];
            }
            sb.append(add).append(" ");
            idx++;
        }
        return sb.append(getNLineNumber(arr, 1)).toString();
    }

    private static int getSequence(int[] S, int[] arr) {
        int answer = 1;
        for (int i = 0; i < S.length - 1; i++) {
            int num = S[i];
            int sequence = getSequenceOfArr(num, arr);
            if (sequence == 1) continue;
            answer += fac[i + 1] * (sequence - 1);
        }

        return answer;
    }

    private static int getSequenceOfArr(int n, int[] arr) {
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                answer++;
                if (arr[i] == n) {
                    arr[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    private static int getNLineNumber(int[] arr, int n) {
        int result = 0;
        if (n == Integer.MAX_VALUE) {
            for (int i = arr.length - 1; i >= 1; i--) {
                if (arr[i] != 0) {
                    result = arr[i];
                    arr[i] = 0;
                    break;
                }
            }
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != 0) {
                    n--;
                    if (n == 0) {
                        result = arr[i];
                        arr[i] = 0;
                        break;
                    }
                }
            }
        }

        return result;
    }

    static class Answer {
        public static void main(String[] args) throws IOException {
            int N, Q;
            long F[] = new long[21];
            int S[] = new int[21];

            boolean visited[] = new boolean[21];
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            Q = Integer.parseInt(st.nextToken());
            F[0] = 1;

            for (int i = 1; i <= N; i++) {
                F[i] = F[i - 1] * i;
            }

            if (Q == 1) {
                long K = Long.parseLong(st.nextToken());
                for (int i = 1; i <= N; i++) {
                    for (int j = 1, cnt = 1; j <= N; j++) {
                        if (visited[j]) continue;
                        if (K <= cnt * F[N - i]) {
                            K -= ((cnt -1) * F[N - i]);
                            S[i] = j;
                            visited[j] = true;
                            break;
                        }
                        cnt++;
                    }
                }

                for (int i = 1; i <= N; i++) {
                    System.out.println(S[i] + " ");
                }
            } else {
                long K = 1;
                for (int i = 1; i <= N; i++) {
                    S[i] = Integer.parseInt(st.nextToken());
                    long cnt = 0;
                    for (int j = 1; j < S[i]; j++) {
                        if (!visited[j]) cnt++;
                    }
                    K += cnt * F[N - i];
                    visited[S[i]] = true;
                }

                System.out.println(K);
            }
        }
    }
}
