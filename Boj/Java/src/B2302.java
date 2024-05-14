import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] vip = new int[m];
        for (int i = 0; i < m; i++) vip[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        for (int i = 1; i < 41; i++) {
            if (i < 4) dp[i] = i;
            else dp[i] = dp[i - 1] + dp[i - 2];
        }

        if (m == 0) {
            System.out.print(dp[n]);
            return;
        }

        int answer = 1;
        int idx = 0;
        for (int i = 0; i < m; i++) {
            answer *= dp[vip[i] - idx - 1];
            idx = vip[i];
        }
        answer *= dp[n - vip[m - 1]];
        System.out.print(answer);
    }
}
