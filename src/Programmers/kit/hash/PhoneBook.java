package Programmers.kit.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> key = new HashMap<>();
        for (String phone : phone_book) {
            key.put(phone, 1);
        }

        for (String phone : phone_book) {
            for (int i = phone.length() - 1; i > 0; i--) {
                String a = phone.substring(0, i);
                if (key.containsKey(a)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean previous(String[] phone_book) {
        Map<String, Boolean> book = new HashMap<>();
        for (String phone : phone_book) {
            book.put(phone, true);
        }

        for (String phone : phone_book) {
            for (int i = phone.length() - 1; i > 0; i--) {
                if (book.containsKey(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
