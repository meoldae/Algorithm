import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
당연히 백트래킹이라고 생각 했는데, N이 100인거 보고 DP 생각
2 ^ 99..
 */
public class B5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        long[][] dp = new long[21][N];
        dp[nums[0]][0] = 1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[j][i - 1] != 0) {
                    if (j + nums[i] <= 20) dp[j + nums[i]][i] += dp[j][i - 1];
                    if (j - nums[i] >= 0) dp[j - nums[i]][i] += dp[j][i - 1];
                }
            }
        }
        System.out.print(dp[nums[N - 1]][N - 2]);
    }
}
