import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        
        List<Integer> reverse = new ArrayList<>(map.keySet());
        reverse.sort((o1, o2) -> map.get(o2) - map.get(o1));
    
        int sum = 0;
        
        for (int t : reverse) {
            answer++;
            sum += map.get(t);
            if (sum >= k) break;
        }
        
        return answer;
    }
    
  
}