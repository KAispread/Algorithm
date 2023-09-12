package Programmers.kit.hash;

import java.util.HashMap;
import java.util.Map;

public class Marathon {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> part = new HashMap<>();
        for (String person: participant) {
            part.put(person, part.getOrDefault(person, 0) + 1);
        }
        for (String person: completion) {
            part.put(person, part.get(person) - 1);
        }

        for (Map.Entry<String, Integer> entry: part.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }

        throw new AssertionError();
    }

    public String answer(String[] participant, String[] completion) {
        Map<String, Integer> partMap = new HashMap<>();
        for (String part : participant) {
            partMap.put(part, partMap.getOrDefault(part, 0) + 1);
        }
        for (String com : completion) {
            partMap.put(com, partMap.get(com) - 1);
        }

        for (Map.Entry entry : partMap.entrySet()) {
            if ((Integer) entry.getValue() > 0) {
                return String.valueOf(entry.getKey());
            }
        }

        return null;
    }
}
