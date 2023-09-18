package Programmers.kit.hash;

import java.util.*;

// LEVEL3 -> 베스트 앨범
public class BestAlbum {

    // 합계: 86.7 / 100.0
    public static class Try {
        public static int[] solution(String[] genres, int[] plays) {
            Map<String, Integer> rank = new HashMap<>();
            Map<String, List<GenrePlay>> genreMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                int play = plays[i];

                rank.put(genre, rank.getOrDefault(genre, 0) + play);
                List<GenrePlay> p = genreMap.getOrDefault(genre, new ArrayList<GenrePlay>());
                p.add(new GenrePlay(i, play));

                genreMap.put(genre, p);
            }

            List<GenreRank> genreRanks = getGenreRank(rank);
            List<Integer> result = new ArrayList<>();

            for (GenreRank genreRank : genreRanks) {
                String genre = genreRank.genre;
                List<GenrePlay> play = genreMap.get(genre);

                if (play == null) throw new AssertionError();

                if (play.size() == 1) {
                    result.add(play.get(0).index);
                    break;
                }

                play.sort((o1, o2) -> {
                    if (o1.count == o2.count)  {
                        return o1.index - o2.index;
                    }
                    return o2.count - o1.count;
                });

                for (int i = 0; i < 2; i++) {
                    result.add(play.get(i).index);
                }
            }

            return result.stream().mapToInt(i -> i).toArray();
        }

        public static List<GenreRank> getGenreRank(Map<String, Integer> rank) {
            List<GenreRank> genreRanks = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : rank.entrySet()) {
                genreRanks.add(new GenreRank(entry.getKey(), entry.getValue()));
            }

            genreRanks.sort((o1, o2) -> o2.play - o1.play);
            return genreRanks;
        }

        public static class GenreRank {
            String genre;
            int play;

            public GenreRank(String genre, int play) {
                this.genre = genre;
                this.play = play;
            }
        }

        public static class GenrePlay {
            int index;
            int count;

            public GenrePlay(int index, int count) {
                this.index = index;
                this.count = count;
            }
        }
    }

    public static class Answer {
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
}
