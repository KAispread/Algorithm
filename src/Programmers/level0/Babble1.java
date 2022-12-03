package Programmers.level0;
/*
*  레벨 0 - 옹알이(1)
* */
public class Babble1 {
    public static void main(String[] args) {
        String[] bab = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(solution(bab));
    }
    private static final String[] BABBLE = {"aya", "ye", "woo", "ma"};

    public static int solution(String[] babbling) {
        int answer = 0;

        for (String babble : babbling) {
            if (isSpeakable(babble)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isSpeakable(String babble) {
        String buffer = babble;
        while (buffer.length() > 0) {
            String given = containBabble(buffer);
            if (given == null) {
                break;
            }
            buffer = removeBabble(buffer, given);
        }
        return buffer.isEmpty();
    }

    private static String containBabble(String babble) {
        for (String givenBabble : BABBLE) {
            if (babble.startsWith(givenBabble)) {
                return givenBabble;
            }
        }
        return null;
    }

    private static String removeBabble(String buffer, String givenBabble) {
        return buffer.replaceFirst(givenBabble, "");
    }
}
