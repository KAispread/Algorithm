import java.util.*;

class Solution {
    private Map<String, String> idNameMap = new HashMap<>();
    private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
    private static final String LEAVE_MESSAGE = "님이 나갔습니다.";
    private static final String ENTER_FLAG = "Enter";
    private static final String LEAVE_FLAG = "Leave";
    private static final String CHANGE_FLAG = "Change";
    
    // 첫 순회 때 Map에 id에 해당하는 사람의 최종 닉네임을 저장
    // 다시 record를 순회하며 행위에 대한 문자 출력
    public String[] solution(String[] record) {
        // 1. 닉네임 저장
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            
            String flag = st.nextToken();
            String id = st.nextToken();
            
            if (flag.equals(ENTER_FLAG) || flag.equals(CHANGE_FLAG)) {
                String name = st.nextToken();
                idNameMap.put(id, name);
            }
        }
        
        
        // 2. 문자 저장
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            
            String flag = st.nextToken();
            String id = st.nextToken();
            
            if (flag.equals(ENTER_FLAG)) {
                answer.add(idNameMap.get(id) + ENTER_MESSAGE);
            } else if (flag.equals(LEAVE_FLAG)) {
                answer.add(idNameMap.get(id) + LEAVE_MESSAGE);
            }
        }
        
        return answer.toArray(new String[0]);
    }
}