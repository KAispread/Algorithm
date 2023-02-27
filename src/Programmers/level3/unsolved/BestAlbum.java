package Programmers.level3.unsolved;

import java.util.*;

/*
* 베스트 앨범
* */
public class BestAlbum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500})));
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + plays[i]);
        }

        List<Genre> buffer = new ArrayList<>();
        for (Map.Entry entry : genreMap.entrySet()) {
            buffer.add(new Genre((String) entry.getKey(), (Integer) entry.getValue()));
        }
        buffer.sort((o1, o2) -> o2.getTotalPlays() - o1.getTotalPlays());

        List<Integer> bestAlbum = new ArrayList<>();

        for (Genre gen: buffer) {
            String genre = gen.getGen();

            int firstMax = -1;
            int secondMax = -1;
            int firstIndex = -1;
            int secondIndex = -1;
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) {
                    if (firstMax < plays[i]) {
                        if (firstMax > 0) {
                            secondMax = firstMax;
                            secondIndex = firstIndex;
                        }
                        firstMax = plays[i];
                        firstIndex = i;
                        continue;
                    }
                    if (secondMax < plays[i]) {
                        secondMax = plays[i];
                        secondIndex = i;
                    }
                }
            }
            bestAlbum.add(firstIndex);
            if (secondIndex != -1) {
                bestAlbum.add(secondIndex);
            }
        }

        return bestAlbum.stream().mapToInt(Integer::valueOf).toArray();
    }

    static class Genre {
        private String gen;
        private int totalPlays;

        public Genre(String gen, int totalPlays) {
            this.gen = gen;
            this.totalPlays = totalPlays;
        }

        public String getGen() {
            return gen;
        }

        public int getTotalPlays() {
            return totalPlays;
        }
    }
}
