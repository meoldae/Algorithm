import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1520 {
    static int[][] dp;
    //    static int count = 0;
//    static boolean[][] visited;
    static int[][] board;
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        board = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

//        visited = new boolean[m][n];
//        visited[0][0] = true;

        // 시작점은 항상 1이어야 함. 출발지
//        dp[0][0] = 1;
        bottomUp(m - 1, n - 1);
        System.out.println(dp[m-1][n-1]);

    }

    // Bottom - Up DFS 도착점에서 시작점으로 탐색
    static int bottomUp(int x, int y) {
        // 시작점 도달했을 때 ( 여기부터 합산하면서 갱신 )
        if (x == 0 && y == 0){
            return 1;
        }
        // 이미 탐색한 곳 합산
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int cases = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if ((0 <= nx && nx < m) && (0 <= ny && ny < n)) {
                if (board[nx][ny] > board[x][y]) {
                    // 도착지에서 출발점으로 가는 방법 갱신
                    cases += bottomUp(nx, ny);
                }
            }
        }
        dp[x][y] = cases;
        return dp[x][y];
    }
}
