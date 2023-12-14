import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7579 {
    static int MEMORY = 0;
    static int COST = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] item = new int[N][2];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            item[i][MEMORY] = Integer.parseInt(st.nextToken());
            item[i][COST] = Integer.parseInt(st1.nextToken());
            max += item[i][COST];
        }
        int[] dp = new int[max + 1];
        for (int i = 0; i < N; i++) {
            for (int j = max; j >= item[i][COST]; j--) {
                dp[j] = Math.max(dp[j - item[i][COST]] + item[i][MEMORY], dp[j]);
            }
        }

        for (int i = 0; i <= max; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}