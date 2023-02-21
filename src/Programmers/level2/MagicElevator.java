package Programmers.level2;

/*
* 마법의 엘리베이터
* */
public class MagicElevator {
    private int answer = 100000;

    public int solution(int storey) {
        getMinStone(storey, 0);
        return answer;
    }

    private void getMinStone(int floor, int count) {
        if (floor < 10) {
            answer = Math.min(answer,
                    Math.min(count + floor, count + 10 - floor + 1));
            return;
        }

        int current = floor % 10;
        int next = floor / 10;

        getMinStone(next + 1, count + 10 - current);
        getMinStone(next, count + current);
    }
}
