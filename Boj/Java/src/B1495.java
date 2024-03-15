import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] volumes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) volumes[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[M + 1];
        Arrays.fill(dp, -1);
        dp[S] = 0;

        for (int i = 1; i <= N; i++) {
            List<Integer> temp = new LinkedList<>();
            for (int j = 0; j <= M; j++) {
                if (dp[j] == i - 1) {
                    if (j + volumes[i - 1] <= M) temp.add(j + volumes[i - 1]);
                    if (j - volumes[i - 1] >= 0) temp.add(j - volumes[i - 1]);
                }
            }
            for (int volume : temp) {
                dp[volume] = i;
            }
        }

        int answer = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[i] == N) answer = Math.max(answer, i);
        }
        System.out.print(answer);
    }
}