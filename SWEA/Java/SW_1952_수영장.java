import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_1952_수영장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++){
            int[][] dp = new int[12][3];
            for (int[] d : dp){
                Arrays.fill(d, Integer.MAX_VALUE);
            }
            int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dp[0][0] = prices[0] * prices[0]; // 일일 단위
            dp[0][1] = (plan[0] > 0) ? prices[1] : 0; // 월 단위

            for (int i = 1; i < 12; i++){
                int minVal = Arrays.stream(dp[i-1]).min().getAsInt();
                if (plan[i] > 0 ){
                    dp[i][0] = minVal + (plan[i] * prices[0]);
                    dp[i][1] = minVal + prices[1];
                    if (i % 3 == 0 || i >= 9){
                        dp[i][2] = Arrays.stream(dp[i-2]).min().getAsInt() + prices[2];
                    }
                }else {
                    dp[i][0] = minVal;
                    dp[i][1] = minVal;
                    dp[i][2] = minVal;
                }
            }
            int answer = Math.min(dp[11][2], prices[3]);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
