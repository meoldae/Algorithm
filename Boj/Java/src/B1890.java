import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1890 {
    static int[][] board;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1L;
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(dfs(N - 1, N - 1));
    }

    static long dfs(int x, int y) {
        if (x == 0 & y == 0) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        long cases = 0;
        for (int i = 1; i <= x; i++) {
            if (board[x - i][y] == i) cases += dfs(x - i, y);
        }

        for (int i = 1; i <= y; i++) {
            if (board[x][y - i] == i) cases += dfs(x, y - i);
        }
        dp[x][y] = cases;
        return dp[x][y];
    }
}
