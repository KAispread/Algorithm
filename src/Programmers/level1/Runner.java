package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

/*
* 달리기 경주
* */
public class Runner {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String caller = callings[i];
            int idx = rank.get(caller);
            String frontRunner = players[idx - 1];

            players[idx] = frontRunner;
            players[idx-1] = caller;

            rank.put(frontRunner, idx);
            rank.put(caller, idx-1);
        }

        return players;
    }
}
