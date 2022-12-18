package Programmers.level0;

/*
* 컨트롤 Z
* */
public class ControlZ {
    public int solution(String s) {
        String[] removeZ = s.split("Z");
        if (s.length() - s.replaceAll("Z", "").length() == 0) {
            return addAll(removeZ[0], false);
        }
        int answer = 0;
        for (int i = 0; i < removeZ.length; i++) {
            if (i == removeZ.length - 1 && s.charAt(s.length() - 1) != 'Z' ) {
                answer += addAll(removeZ[i], false);
                continue;
            }
            answer += addAll(removeZ[i], true);
        }
        return answer;
    }

    private int addAll(String number, boolean Zflag) {
        String[] numbers = number.split(" ");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (!numbers[i].isBlank()) {
                sum += Integer.parseInt(numbers[i].replaceAll(" ", ""));
            }
        }
        if (Zflag && !numbers[numbers.length - 1].isBlank()) {
            sum -= Integer.parseInt(numbers[numbers.length - 1].replaceAll(" ", ""));
        }
        return sum;
    }
}
