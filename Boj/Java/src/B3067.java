import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3067 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());
            int[] coins = new int[l];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < l; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(br.readLine());
            int[][] dp = new int[l + 1][target + 1];
            for (int j = 1; j <= l; j++) {
                dp[j][0] = 1;
                for (int k = 1; k <= target; k++) {
                    if (k - coins[j - 1] >= 0) {
                        dp[j][k] = dp[j - 1][k] + dp[j][k - coins[j - 1]];
                    } else {
                        dp[j][k] = dp[j - 1][k];
                    }
                }
            }
            sb.append(dp[l][target]).append("\n");
        }
        System.out.print(sb);
    }
}
