package Programmers.level2.unsolved;

import java.util.HashMap;
import java.util.Map;

/*
* 조이스틱
* */
public class JoyStick {
    static boolean[] complete;
    static Map<String, Integer> alphaKey = new HashMap<>();
    static int len;

    public int solution(String name) {
        int count = 0;
        alphaKey.put("A", 0);
        complete = new boolean[name.length()];
        len = name.length();

        for (char i = 'B'; i <= 'Z'; i++) {
            String s = String.valueOf(i);
            if (i > 'N') {
                count--;
            } else {
                count++;
            }
            alphaKey.put(s, count);
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                complete[i] = true;
            }
        }

        while (!allCheck()) {

        }

        int answer = 0;
        return answer;
    }

    private int checkIdx(int index) {
        for (int i = 0; i < complete.length; i++) {
            if (!complete[i]) {}
        }
        return 0;
    }

    private boolean allCheck() {
        for (boolean flag : complete) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
