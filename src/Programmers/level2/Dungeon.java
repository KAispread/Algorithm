package Programmers.level2;

/*
* 피로도
* */
public class Dungeon {
    static boolean visited[];
    static int max = 0;
    static int[][] place;

    public int solution(int k, int[][] dungeons) {
        place = dungeons;
        for (int i = 0; i < dungeons.length; i++) {
            visited = new boolean[dungeons.length];
            visited[i] = true;
            DFS(k, i, 1);
        }

        return max;
    }

    private void DFS(int current, int node, int depth) {
        if (current < place[node][0]) {
            return;
        }
        if (max < depth) {
            max = depth;
        }

        int p = current - place[node][1];

        for (int i = 0; i < place.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(p, i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
