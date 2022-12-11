package Programmers.level0;

public class ChickenCoupon {
    public static void main(String[] args) {
        solution(100);
    }

    private static final int COUPON = 10;
    public static int solution(int chicken) {
        int bonus = 0;
        while (chicken >= COUPON) {
            bonus += chicken / COUPON;
            chicken = chicken / COUPON + chicken % COUPON;
        }
        return bonus;
    }
}
