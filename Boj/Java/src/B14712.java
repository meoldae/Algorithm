import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14712 {

    static int[][] board;
    static int answer;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];

        dfs(1, 1);
        System.out.print(answer);
    }

    static void dfs(int x, int y) {
        if (x > N) { // 마지막 칸까지 도달
            answer++;
            return;
        }

        // 다음 단계 탐색
        int nx = (y == M) ? x + 1 : x;
        int ny = (y == M) ? 1 : y + 1;

        if (board[x][y - 1] + board[x - 1][y] + board[x - 1][y - 1] == 3) { // 2X2 로 못 두는 경우
            dfs(nx, ny);
        }else {
            board[x][y] = 1;
            dfs(nx, ny);

            board[x][y] = 0;
            dfs(nx, ny);
        }
    }
}
