import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11060 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] maze = new int[n];
        for (int i = 0; i < n; i++) maze[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        Arrays.fill(dp, 1001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= maze[i]; j++) {
                if (i + j >= n || maze[i] == 0) continue;
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        System.out.println(dp[n - 1] == 1001 ? -1 : dp[n - 1]);
    }
}
