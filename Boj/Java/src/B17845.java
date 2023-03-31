import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] priority = new int[K + 1];
        int[] time = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            priority[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= K; i++) {
            for (int j = N; j > 0; j--) {
                if (j < time[i]) break;
                dp[j] = Math.max(dp[j], dp[j-time[i]] + priority[i]);
                answer = Math.max(answer, dp[j]);
            }
        }
        System.out.print(answer);
    }
}
