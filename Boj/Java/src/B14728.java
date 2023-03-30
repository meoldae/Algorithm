import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] question = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            question[i][0] = Integer.parseInt(st.nextToken());
            question[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = K; j > 0; j--) {
                int w = question[i - 1][0];
                int v = question[i - 1][1];
                if (j < w) break;
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.print(dp[K]);
    }
}
