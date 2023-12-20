import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2688 {

    // 0 1 2 3 4 5 6 7 8 9
    // (00 01 02 ... 09) (11 12 13 ... 19) (22 23 24 ... 29) > 10 9 8 7 ... 1
    // 0: 2자리 중 0~9부터 시작  1: 2자리 중 1~9부터 시작  2: 2자리 중 2~9부터 시작
    // 0: 3자리 중 0~9부터 시작 ...

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(getUnabatedNumber(n));
        }
    }

    public static long getUnabatedNumber(int n) {
        long[][] dp = new long[n + 1][10];

        Arrays.fill(dp[1], 1L); // 1자리의 경우 전부

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        long answer = 0;
        for (long l : dp[n]) answer += l;
        return answer;
    }
}
