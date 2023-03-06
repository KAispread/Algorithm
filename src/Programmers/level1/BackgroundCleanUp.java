package Programmers.level1;

/*
* 바탕화면 정리
* */
public class BackgroundCleanUp {
    public int[] solution(String[] wallpaper) {
        int startX = 100;
        int startY = 100;
        int endX = 0;
        int endY = 0;

        for (int r = 0; r < wallpaper.length; r++) {
            for (int i = 0; i < wallpaper[r].length(); i++) {
                if (wallpaper[r].charAt(i) == '#') {
                    startX = Math.min(startX, r);
                    startY = Math.min(startY, i);
                    endX = Math.max(endX, r + 1);
                    endY = Math.max(endY, i + 1);
                }
            }
        }

        return new int[] {startX, startY, endX, endY};
    }
}
