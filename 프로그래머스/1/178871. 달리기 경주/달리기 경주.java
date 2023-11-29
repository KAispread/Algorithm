import java.util.*;

class Solution {

   public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < players.length; i++){
            String player = players[i];
            map.put(player,i);
        }

        for(String calling : callings){
            int index = map.get(calling);
            String forwardCalling = players[index - 1];

            players[index - 1] = calling;
            map.put(calling,index-1);

            players[index] = forwardCalling;
            map.put(forwardCalling,index);
        }
        return players;
    }

}