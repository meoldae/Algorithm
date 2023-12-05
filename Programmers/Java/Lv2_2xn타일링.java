class Solution {
    public int solution(int n) {
        int[] answer = new int[n + 1];
        answer[1] = 1;
        answer[2] = 2;
        
        if (n < 3) return answer[n];
        
        for (int i = 3; i <= n; i++) answer[i] = (answer[i-1] + answer[i-2]) % 1000000007;
                
        return answer[n];
    }
}