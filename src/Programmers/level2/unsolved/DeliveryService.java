package Programmers.level2.unsolved;

/*
* 택배 수거하기 - 95/100
* */
public class DeliveryService {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long remain = 0;
        long answer = 0;

        int pickUpPoint = pickups.length - 1;
        int deliveryPoint = pickUpPoint;

        for (int d : deliveries) {
            remain += d;
        }

        while (deliveries[deliveryPoint] < 1) {
            deliveryPoint--;
        }
        while (pickups[pickUpPoint] < 1) {
            pickUpPoint--;
        }

        // 거리
        int point = Math.max(deliveryPoint, pickUpPoint);

        while (point >= 0) {
            int pack = cap;
            if (cap > remain) pack = (int) remain;

            // 배달
            while (deliveryPoint >= 0) {
                int d = deliveries[deliveryPoint];
                if (d == 0) {
                    deliveryPoint--;
                    continue;
                }

                if (pack <= 0) break;

                int delivery = Math.min(deliveries[deliveryPoint], pack);

                deliveries[deliveryPoint] -= delivery;

                if (deliveries[deliveryPoint] <= 0) {
                    deliveryPoint--;
                }
                remain -= (long) delivery;
                pack -= delivery;
            }

            // 수거
            while (pickUpPoint >= 0) {
                int p = pickups[pickUpPoint];
                if (p == 0) {
                    pickUpPoint--;
                    continue;
                }

                if (pack >= cap) break;

                if (p <= cap - pack) {
                    pickups[pickUpPoint] = 0;
                    pack += p;
                    pickUpPoint--;
                } else {
                    pickups[pickUpPoint] -= cap - pack;
                    pack = cap;
                }
            }
            answer += (point + 1) * 2;
            point = Math.max(deliveryPoint, pickUpPoint);
        }

        return answer;
    }

    static class Answer {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;

            int d=0;
            int p=0;

            int size=cap;

            for(int i=n-1;i>=0;i--){
                if(deliveries[i]!=0){
                    d=i+1;
                    break;
                }
            }

            for(int i=n-1;i>=0;i--){
                if(pickups[i]!=0){
                    p=i+1;
                    break;
                }
            }

            while(true){
                // 종료조건
                if(d==0&&p==0){
                    break;
                }
                //거리 계산
                answer+=(Math.max(d,p))*2;

                //배달하기
                while(true){
                    if(d==0||cap==0&&deliveries[d-1]!=0){
                        break;
                    }
                    if(cap>=deliveries[d-1]){
                        cap-=deliveries[d-1];
                        deliveries[d-1]=0;
                        d--;
                    }
                    else{
                        deliveries[d-1]-=cap;
                        cap=0;
                    }
                    if(d==0){
                        break;
                    }

                    if(cap==0&&deliveries[d-1]==0){
                        d--;
                    }
                }

                cap=size;

                //픽업하기
                while(true){
                    if(p==0||cap==0&&pickups[p-1]!=0){
                        break;
                    }

                    if(cap>=pickups[p-1]){
                        cap-=pickups[p-1];
                        pickups[p-1]=0;
                        p--;
                    }
                    else{
                        pickups[p-1]-=cap;
                        cap=0;
                    }

                    if(p==0){
                        break;
                    }

                    if(cap==0&&pickups[p-1]==0){
                        p--;
                    }

                }

                cap=size;
            }



            return answer;
        }
    }
}
