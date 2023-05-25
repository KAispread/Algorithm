package Programmers.level2;

import java.util.Stack;

/*
* 택배 상자
* */
public class ParcelBox {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int truckIdx = 0;

        for (int i = 0; i < order.length; i++) {
            sub.push(i + 1);

            while (truckIdx < order.length && !sub.isEmpty()) {
                if (sub.peek() == order[truckIdx]) {
                    sub.pop();
                    truckIdx++;
                } else {
                    break;
                }
            }
        }

        return truckIdx;
    }
}
