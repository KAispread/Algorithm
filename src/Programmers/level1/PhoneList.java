package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

/*
* 전화번호부 목록
* */
public class PhoneList {
    public static void main(String[] args) {
        solution(new String[]{"123","456","789"});
    }

    public static boolean solution(String[] phone_book) {
        Map<String, Boolean> book = new HashMap<>();
        for (String phone : phone_book) {
            if (book.isEmpty()) {
                book.put(phone, true);
            }
            for (Map.Entry entry : book.entrySet()) {
                String key = String.valueOf(entry.getKey());
                if ( key.startsWith(phone) || phone.startsWith(key)) {
                    return false;
                }
            }
        }
        return true;
    }
}
