import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        Queue<Group> pQueue = new PriorityQueue<>((g1, g2) -> g2.sum - g1.sum);
        
        int max = Math.min(picks[0] * 5 + picks[1] * 5 + picks[2] * 5, minerals.length);
        
        
        for (int i = 0; i < max; i++) {
            int cnt = 0;
            Group group = new Group();
            while (cnt < 5 && i < max) {
                group.add(minerals[i]);
                cnt++;
                i++;
            }
            i--;
            pQueue.offer(group);
        }
        
        int tired = 0;
        while (!pQueue.isEmpty()) {
            Group group = pQueue.poll();
            Pick pick = null;
            if (picks[0] > 0) {
                pick = Pick.DIA;
                picks[0]--;
            } else if (picks[1] > 0) {
                pick = Pick.IRON;
                picks[1]--;
            } else if (picks[2] > 0) {
                pick = Pick.STONE;
                picks[2]--;
            }
            if (pick == null) break;
            tired += pick.getTired(group.d, group.i, group.s);
        }
        
        return tired;
    }
    
    static class Group {
        int d, i, s;
        int sum;
        
        public Group() {
            this.d = 0;
            this.i = 0;
            this.s = 0;
            this.sum = 0;
        }
        
        public void add (String mineral) {
            if (mineral.equals("diamond")) {
                this.d += 1;
                this.sum += 50;
            } else if (mineral.equals("iron")) {
                this.i += 1;
                this.sum += 10;
            } else {
                this.s += 1;
                this.sum += 1;
            }
        }
    }
    
    enum Pick {
        DIA(1, 1, 1),
        IRON(5, 1, 1),
        STONE(25, 5, 1);
        
        private final int diamond;
        private final int iron;
        private final int stone;
        
        Pick (int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
        
        public int getTired(int d, int i, int s) {
            int sum = 0;
            sum += diamond * d;
            sum += iron * i;
            sum += stone * s;
            return sum;
        }
    }
}