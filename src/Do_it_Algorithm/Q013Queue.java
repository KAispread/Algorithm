package Do_it_Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 백준 2164번 Silver IV
* Priority Queue  -> Comparator 을 구현한 인스턴스를 가질 때, 자동으로 우선순위를 정렬해줌
* LinkedList -> front, rear 개념이 있는 일반적인 Queue 자료구조
* */
public class Q013Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> cardTop = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cardTop.add(i);
        }

        for (int i =0; i < N - 1; i++) {
            cardTop.poll();
            Integer nextCard = cardTop.poll();
            cardTop.add(nextCard);
        }

        System.out.println(cardTop.peek());
    }
}
