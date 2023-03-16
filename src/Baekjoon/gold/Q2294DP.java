package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 2294 - 동전2 - Gold V
* */
public class Q2294DP {
    static int n,k;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n+1];

        for(int i=1;i<=n;i++)
        {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] dp=new int[k+1];

        for(int i=1;i<=k;i++){
            dp[i]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n;i++){
            for(int j=arr[i];j<=k;j++){
                dp[j]=Math.min(dp[j],dp[j-arr[i]]+1);
            }
        }

        if(dp[k]==Integer.MAX_VALUE-1)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
