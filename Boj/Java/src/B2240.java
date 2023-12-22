import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] plum = new int[T];
        for (int i = 0; i < T; i++) {
            plum[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[T][W + 1][2];
        if ((plum[0] & 1) == 1) {
            dp[0][0][0] = 1; // 자두 획득
            if (W >= 1) {
                dp[0][1][1] = 0; // 자두 놓침
            }
        } else {
            dp[0][0][0] = 0; // 자두 놓침
            if (W >= 1) {
                dp[0][1][1] = 1; // 자두 획득
            }
        }

        for (int i = 1; i < T; i++) {
            if ((plum[i] & 1) == 1) { // 1번나무

                dp[i][0][0] = dp[i-1][0][0] + 1;    // 자두 획득
                dp[i][0][1] = dp[i-1][0][1];        // 자두 놓침

                for (int w = 1; w <= W; w++) {
                    dp[i][w][0] = Math.max(dp[i-1][w][0], dp[i-1][w-1][1]) + 1; // 자두 획득
                    dp[i][w][1] = Math.max(dp[i-1][w-1][0], dp[i-1][w][1]);     // 자두 놓침
                }

            }else { // 2번나무
                dp[i][0][0] = dp[i-1][0][0];        // 자두 놓침
                dp[i][0][1] = dp[i-1][0][1] + 1;    // 자두 획득

                for (int w = 1; w <= W; w++) {
                    dp[i][w][1] = Math.max(dp[i-1][w][1], dp[i-1][w-1][0]) + 1; // 자두 획득
                    dp[i][w][0] = Math.max(dp[i-1][w-1][1], dp[i-1][w][0]);     // 자두 놓침
                }
            }
        }

        int answer = 0;
        for (int w = 0; w <= W; w++) {
            answer = Math.max(answer, Math.max(dp[T-1][w][0], dp[T-1][w][1]));
        }
        System.out.print(answer);
    }
}
