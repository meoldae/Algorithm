import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int price = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= n; j++) {
                if (j - i < 0) continue;
                dp[j] = Math.max(dp[j], dp[j - i] + price);
            }
        }
        System.out.println(dp[n]);
    }
}
