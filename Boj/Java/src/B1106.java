import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()) + 101;
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j = customer; j < C; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer] + cost);
            }
        }

        int answer = 10000000;
        for (int i = C - 101; i < C; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.print(answer);
    }
}
