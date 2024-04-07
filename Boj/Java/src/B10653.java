import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] checkpoints = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            checkpoints[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int[][] dp = new int[K + 1][N];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = getDistance(checkpoints[1], checkpoints[0]);

        for (int i = 1; i < N; i++) {
            for (int k = 0; k <= K; k++) {
                // No Skip
                if (dp[k][i - 1] != Integer.MAX_VALUE) dp[k][i] = Math.min(dp[k][i], dp[k][i - 1] + getDistance(checkpoints[i], checkpoints[i - 1]));
                // Skip
                for (int j = 1; j <= k; j++) {
                    if (i - j > 0 && dp[k - j][i - j - 1] != Integer.MAX_VALUE) dp[k][i] = Math.min(dp[k][i], dp[k - j][i - j - 1] + getDistance(checkpoints[i], checkpoints[i - j - 1]));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            answer = Math.min(answer, dp[i][N - 1]);
        }
        System.out.print(answer);
    }

    public static int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
