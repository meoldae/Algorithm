class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 체력 상한선
        int maxHealth = health;
        // 시간 차이 계산을 위한 이전 공격시간
        int prev = 0;
        for (int i = 0; i < attacks.length; i++) {
            
            if (prev == 0) {
                health -= attacks[i][1];
                prev = attacks[i][0];
                continue;
            }
            
            // 공격받은 상황에는 회복 불가 
            int diff = attacks[i][0] - prev - 1;
            prev = attacks[i][0];
            int cycle = diff / bandage[0];

            health += ((cycle * bandage[2]) + (diff * bandage[1]));
            
            if (health >= maxHealth) {
                health = maxHealth;
            }
            
            health -= attacks[i][1];
            
            // 체력이 0 이하가 되어 사망처리
            if (health <= 0) {
                return -1;
            }
        }
        return health;
    }
}