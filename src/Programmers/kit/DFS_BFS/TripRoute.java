package Programmers.kit.DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LEVEL3 - 여행경로
public class TripRoute {
    /*
    DFS 로 풀자
    - ICN 공항에서 시작하여, 각 공항에서 갈 수 있는 공항의 리스트를 List<>[] 형태로 저장함
    - 한 번 사용한 티켓을 다시 사용하지 않도록, 객체를 생성하고 Map에 사용 여부를 기록함 class Ticket
    - 갈 곳이 없다면? 모든 티켓을 사용했는지 확인 후, 여행 경로에 기록
    - 경로는 어떻게 기록? List로 하나하나 추가하자
    */
    public Map<String, List<Ticket>> ticketMap = new HashMap<>();
    public Map<Ticket, Boolean> useMap = new HashMap<>();
    public List<String> answer= new ArrayList<>();

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            Ticket t = new Ticket(ticket[0], ticket[1]);

            List<Ticket> ticketList = ticketMap.getOrDefault(ticket[0], new ArrayList<>());
            ticketList.add(t);

            ticketMap.put(ticket[0], ticketList);
            useMap.put(t, false);
        }

        for (Map.Entry<String, List<Ticket>> entry : ticketMap.entrySet()) {
            List<Ticket> ticketList = entry.getValue();
            // 검증 필요
            ticketList.sort((o1, o2) -> o2.end.compareTo(o1.end));
        }

        List<String> use = new ArrayList<>();
        use.add("ICN");
        DFS("ICN", use);

        return answer.toArray(new String[0]);
    }

    public void DFS(String key, List<String> use) {
        List<Ticket> ticketList = ticketMap.get(key);
        if (ticketList == null || ticketList.isEmpty()) {
            if (usedAllTicket()) {
                answer = new ArrayList<>(use);
            }
            return;
        }

        boolean isDfs = false;
        for (Ticket t : ticketList) {
            if (!useMap.get(t)) {
                isDfs = true;
                useMap.put(t, true);
                use.add(t.end);

                DFS(t.end, use);

                useMap.put(t, false);

                for (int i = use.size() - 1; i >= 0; i--) {
                    if (use.get(i).equals(t.end)) {
                        use.remove(i);
                        break;
                    }
                }
            }
        }

        if (!isDfs && usedAllTicket()) {
            answer = new ArrayList<>(use);
        }
    }

    public boolean usedAllTicket() {
        for (Map.Entry<Ticket, Boolean> entry : useMap.entrySet()) {
            if (!entry.getValue()) return false;
        }

        return true;
    }

    static class Ticket {
        String start;
        String end;

        public Ticket(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

}
