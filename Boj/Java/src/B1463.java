import java.util.Arrays;
import java.util.Scanner;

public class B1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i <= N; i++) {
            if (i > 1) dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            if (i * 2 <= N) dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);

            if (i * 3 <= N) dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }
        System.out.print(dp[N]);
    }
}
