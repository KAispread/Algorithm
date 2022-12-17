package Programmers.level0;

import java.util.Arrays;

/*
* 캐릭터의 좌표
* */
public class DirectionCharacter {
    public static void main(String[] args) {
        solution(new String[] {"left", "right", "up", "right", "right"}, new int[] {11, 11});
    }

    private static int[] xRange;
    private static int[] yRange;

    public static int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        int x = board[0] / 2;
        int y = board[1] / 2;

        xRange = new int[] {-x, x};
        yRange = new int[] {-y, y};

        int[] current = new int[2];

        for (int i = 0; i < keyinput.length; i++) {
            int[] direction = Direction.getDirection(keyinput[i]);
            int moveX = current[0] + direction[0];
            int moveY = current[1] + direction[1];

            if (moveX <= xRange[1] && moveX >= xRange[0] && moveY <= yRange[1] && moveY >= yRange[0]) {
                current[0] = moveX;
                current[1] = moveY;
            }
        }
        return current;
    }

    enum Direction {
        LEFT("left",-1, 0),
        RIGHT("right",1, 0),
        UP("up",0, 1),
        DOWN("down", 0, -1);

        private final String key;
        private final int x;
        private final int y;

        Direction(String key, int x, int y) {
            this.key = key;
            this.x = x;
            this.y = y;
        }

        public static int[] getDirection(String key) {
            Direction direction = Arrays.stream(Direction.values())
                    .filter(direct -> direct.key.equals(key))
                    .findAny()
                    .orElseThrow();
            return new int[] {direction.x, direction.y};
        }
    }
}
