package commuLearning.review.greedy;

// LEVEL3 - 기지국 설치
public class BaseStationInstallation {

    static class Try {
        public int solution(int n, int[] stations, int w) {
            int location = 1;
            int count = 0;
            int stationIndex = 0;

            while (location <= n) {
                if (stationIndex < stations.length &&
                    location <= stations[stationIndex] + w &&
                    location >= stations[stationIndex] - w) {

                    location = stations[stationIndex] + w + 1;
                    stationIndex++;
                } else {
                    location += w * 2 + 1;
                    count++;
                }
            }

            return count;
        }
    }

    static class Answer {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int idx = 1;
            int sIdx = 0;

            while (idx <= n) {
                if (sIdx < stations.length &&
                    idx >= stations[sIdx] - w && idx <= stations[sIdx] + w) {
                    idx = stations[sIdx] + w + 1;
                    sIdx++;
                } else {
                    idx += 2 * w + 1;
                    answer++;
                }
            }

            return answer;
        }
    }

}
