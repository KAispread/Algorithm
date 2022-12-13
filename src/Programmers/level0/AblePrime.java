package Programmers.level0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 유한 소수 판별하기
* */
public class AblePrime {
    public static void main(String[] args) {
        solution(7, 20);
        solution(11, 22);
        solution(12, 21);
    }

    public static int solution(int a, int b) {
        Set<Integer> primeA = getPrime(a);
        Set<Integer> primeB = getPrime(b);
        removeDuplicateElement(primeB, primeA);

        for (Integer prime : primeB) {
            if (prime != 1 && prime % 2 != 0 && prime % 5 != 0) {
                return 2;
            }
        }
        return 1;
    }

    private static Set<Integer> getPrime(int number) {
        Set<Integer> primes = new HashSet<>();
        for (int count = 1; count < number / 2 + 1; count++) {
            if (number % count == 0) {
                int opposite = number / count;
                primes.add(count);
                primes.add(opposite);
            }
        }
        return primes;
    }

    private static void removeDuplicateElement(Set<Integer> target, Set<Integer> given) {
        for (Integer integer : given) {
            target.remove(integer);
        }
    }
}
