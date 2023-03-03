package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* Gold II - 택배
* 1. 도착점 기준 오름차순 -> 시작점 기준 오름차순
* 2. 마을 최대 적재량 배열 생성 = 모든 값을 트럭의 최대 적재량으로 초기화 후 적재 가능한만큼 뺌
* 핵심 -> 첫 마을부터 마지막 마을까지 선형으로 시뮬레이션을 하는 것이 아니라,
*         최대 이득을 볼 수 있는 경우의 수부터 챙기면서 판단 할 수 있는 지표(배열 등)를 업데이트
* */
public class Q8980Greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int town = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        int boxNum = Integer.parseInt(bf.readLine());

        Delivery[] deliveries = new Delivery[boxNum];

        // N - 1 마을 까지 초기화
        int[] townCapacity = new int[town];
        for (int i = 1; i < townCapacity.length; i++) {
            townCapacity[i] = capacity;
        }

        for (int i = 0; i < boxNum; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            deliveries[i] = new Delivery(start, end, c);
        }

        // 도착 오름차순 -> 시작 오름차순 정렬
        Arrays.sort(deliveries, (d1, d2) -> {
            if (d1.end == d2.end) return d1.start - d2.start;
            return d1.end - d2.end;
        });

        int box = 0;
        for (int i = 0; i < deliveries.length; i++) {
            Delivery delivery = deliveries[i];

            // 시작점 ~ 도착점 사이의 최대 적재 가능량 구하기
            int min = 100000;
            for (int m = delivery.start; m < delivery.end; m++) {
                min = Math.min(townCapacity[m], min);
                if (min == 0) break;
            }

            if (min > 0) {
                if (min > delivery.capacity) min = delivery.capacity;

                box += min;
                // 구간별 최대 적재량 업데이트
                for (int m = delivery.start; m < delivery.end; m++) {
                    townCapacity[m] -= min;
                }
            }
        }

        System.out.println(box);
    }

    static class Delivery {
        int start, end;
        int capacity;

        public Delivery(int start, int end, int capacity) {
            this.start = start;
            this.end = end;
            this.capacity = capacity;
        }
    }
}
