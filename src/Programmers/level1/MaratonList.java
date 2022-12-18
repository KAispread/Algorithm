package Programmers.level1;

import java.util.*;

/*
* 완주하지 못한 선수
* Map api 의 getOrDefault 사용
* */
public class MaratonList {
    public static void main(String[] args) {
        solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"});
    }

    public static String solution(String[] participant, String[] completion) {
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
