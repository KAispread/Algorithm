import java.util.*;
import java.util.stream.*;

/*
개인정보 수집 일자가 1일 이라면 전 달 28일까지
수집 일자로부터 +달 -1일 까지 보관 가능 
- 2022년 -> 2022 * 12 * 28
- 11월 -> 11 * 28
- 1일 -> 1
*/
class Solution {
    
    private final Map<String, Integer> termsMap = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 현재 날짜 절대값을 구함
        int todayInt = convertDayToInt(today);
        
        // 약관에 따른 보호 기간을 Map에 저장
        for (String term : terms) {
            String[] t = term.split(" ");
            
            int termInt = Integer.parseInt(t[1]) * 28;
            termsMap.put(t[0], termInt);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        // 개인 정보를 순회하며 약관에 따른 보호 기간을 더하고 현재 날짜보다 작거나 같으면 폐기 
        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            
            int privacyInt = convertDayToInt(p[0]);
            int termInt = termsMap.get(p[1]);
            
            int privacyTermInt = privacyInt + termInt;
            
            if (privacyTermInt <= todayInt) {
                answer.add(i + 1);
            }
        }

        // 정답 반환
        return answer.stream().mapToInt(o1 -> o1).toArray();
    }
    
    private int convertDayToInt(String day) {
        StringTokenizer st = new StringTokenizer(day, ".");
        
        int year = Integer.parseInt(st.nextToken()) * 28 * 12;
        int month = Integer.parseInt(st.nextToken()) * 28;
        int days = Integer.parseInt(st.nextToken());
        
        return year + month + days;
    }
}