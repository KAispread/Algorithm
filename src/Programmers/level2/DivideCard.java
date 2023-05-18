package Programmers.level2;

/*
* 카드 나누기
* */
public class DivideCard {
    public int solution(int[] arrayA, int[] arrayB) {
        if (arrayA.length == 1) {
            int a = arrayA[0];
            int b = arrayB[0];

            return Math.max(a, b);
        }

        int resultA = result(arrayA, arrayB);
        int resultB = result(arrayB, arrayA);

        return Math.max(resultA, resultB);
    }

    private int result(int[] gcdArr, int[] validArr) {
        int g = gcd(Math.max(gcdArr[0], gcdArr[1]), Math.min(gcdArr[0], gcdArr[1]));

        for (int i = 2; i < gcdArr.length; i++) {
            g = gcd(Math.max(gcdArr[i], g), Math.min(gcdArr[i], g));
        }

        for (int v : validArr) {
            if (v % g == 0) return 0;
        }

        return g;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
