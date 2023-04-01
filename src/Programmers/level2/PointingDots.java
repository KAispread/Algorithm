package Programmers.level2;


// 점찍기
public class PointingDots {
    public long solution(int k, int d) {
        long maxPoint = d - (d % k);
        long maxDot = maxPoint / k + 1;
        long total = maxDot * maxDot;

        long currentPoint = 1;
        long idx = maxDot - 1;
        while (idx > 0 && currentPoint < maxDot) {
            double distance = Math.sqrt(Math.pow(currentPoint * k, 2) + Math.pow(idx * k, 2));
            while (distance <= (double) d) {
                currentPoint++;
                distance = Math.sqrt(Math.pow(currentPoint * k, 2) + Math.pow(idx * k, 2));
            }

            total -= maxDot - currentPoint;
            idx--;
        }

        return total;
    }
}
