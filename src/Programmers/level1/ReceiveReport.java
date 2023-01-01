package Programmers.level1;

import java.util.*;

/*
* 신고결과 받기
* */
public class ReceiveReport {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> users = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            users.put(id_list[i], i);
        }

        Set<String>[] rept = new HashSet[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            rept[i] = new HashSet<>();
        }

        for (String rpt : report) {
            String[] part = rpt.split(" ");
            int userIndex = users.get(part[1]);
            rept[userIndex].add(part[0]);
        }

        List<Integer> badUser = new ArrayList<>();
        for (int i = 0; i < rept.length; i++) {
            if (rept[i].size() >= k) {
                badUser.add(i);
            }
        }

        for (int bad : badUser) {
            for (String reporter : rept[bad]) {
                int index = users.get(reporter);
                answer[index] += 1;
            }
        }

        return answer;
    }
}
