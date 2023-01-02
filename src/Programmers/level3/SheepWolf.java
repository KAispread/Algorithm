package Programmers.level3;

import java.util.ArrayList;
import java.util.List;

/*
* 양과 늑대
* */
public class SheepWolf {
    public static void main(String[] args) {
        solution(new int[] {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0}, new int[][] {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}});
    }

    public static int max_sheep;
    public static int[] infos;
    public static boolean[][][] visited;
    public static ArrayList<Integer>[] connect;

    public static int solution(int[] info, int[][] edges) {
        int answer = 0;
        infos = info;

        connect = new ArrayList[info.length];
        for(int i=0;i<info.length;i++){
            connect[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            connect[a].add(b);
            connect[b].add(a);
        }

        visited = new boolean[info.length][info.length+1][info.length+1];
        dfs(0, 0, 0);
        answer = max_sheep;
        return answer;
    }

    public static void dfs(int s, int w, int now){

        if(infos[now] == 0){
            s++;
        } else if(infos[now] == 1){
            w++;
        }


        if(w >= s) return;

        max_sheep = Math.max(max_sheep, s);


        for(int i=0;i<connect[now].size();i++){
            int next = connect[now].get(i);
            int temp = infos[now];
            if(!visited[next][s][w]){
                infos[now] = -1;
                visited[now][s][w] = true;
                dfs(s, w, next);
                infos[now] = temp;
                visited[now][s][w] = false;
            }
        }

    }
}
