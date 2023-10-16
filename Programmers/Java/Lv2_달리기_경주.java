import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 최악의 경우 50000 * 1000000 * 10 
        // 선형탐색 X
        Map<String, Integer> ranking = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }
        
        for (String calling : callings) {
            int rearIndex = ranking.get(calling);
            String rearPlayer = players[rearIndex];
            String frontPlayer = players[rearIndex - 1];
            
            players[rearIndex] = frontPlayer;
            players[rearIndex - 1] = rearPlayer;
            
            ranking.put(frontPlayer, rearIndex);
            ranking.put(rearPlayer, rearIndex - 1);
        }
        return players;
        
    }
}