/*
단순 구현 문제
*/
class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int time = 0;
        
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];
            
            // 힐링
            answer = healing(health, answer, bandage, attackTime - time - 1);
            time = attackTime;
            
            // 몬스터의 공격 
            answer = attack(damage, answer);
            
            if (answer <= 0) return -1;
        }
        
        return answer;
    }
    
    // 힐링
    private int healing(int maxHealth, int current, int[] bandage, int duration) {
        int health = current;
        
        health += duration * bandage[1];
        health += bandage[2] * (duration / bandage[0]);
        
        if (health >= maxHealth) return maxHealth;
        return health;
    }
    
    // 공격
    private int attack(int damage, int current) {
        return current - damage;
    }
}