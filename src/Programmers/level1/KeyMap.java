package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

/*
* 대충 만든 자판
* */
public class KeyMap {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> keys = createKeyMap(keymap);

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            String target = targets[i];
            boolean isKey = true;

            for (int c = 0; c < target.length(); c++) {
                int cnt = keys.getOrDefault(target.charAt(c), -1);

                if (cnt == -1) {
                    isKey = false;
                    break;
                } else {
                    count += cnt;
                }
            }

            if (!isKey) answer[i] = -1;
            else answer[i] = count;
        }

        return answer;
    }

    private Map<Character, Integer> createKeyMap(String[] keymap) {
        Map<Character, Integer> keys = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char alpha = key.charAt(i);
                int count = Math.min(i + 1,
                        keys.getOrDefault(alpha, Integer.MAX_VALUE));
                keys.put(alpha, count);
            }
        }
        return keys;
    }
}
