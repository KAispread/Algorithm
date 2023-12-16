import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//랜선 자르기
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long max=0;
        long mid=0;
        long min=0;
        int l[] = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            l[i] = number;
            if(number>max){
                max = number;
            }
        }
        max++; //+1을 더 해서 시작
        long n;
        while(min<max){
            n=0;
            mid = (min + max) / 2;
            //mid의 랜선의 길이면 필요한 개수 N이 맞는지 검사
            for(int i=0; i<K; i++){
                n += (l[i]/mid);
            }

             /*  [upper bound 형식]
             *
             *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
             *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */

            if(n<N){ // 랜선 개수가 모자라면 max값을 줄임
                max = mid;
            }
            else{
                min = mid +1;
            }
        }
        System.out.print(min-1);
    }
}