import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] polls = new int[n][];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            polls[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        Arrays.sort(polls, (o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(polls[i][1] > polls[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        System.out.print(n - Arrays.stream(dp).max().getAsInt());
    }
}
