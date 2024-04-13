import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1189 {
    static char[][] board;
    static boolean[][] visited;
    static int answer;
    static int R, C, K;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) board[i] = br.readLine().toCharArray();

        visited = new boolean[R][C];
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.print(answer);
    }

    public static void dfs(int x, int y, int d) {
        if (d > K) return;

        if (x == 0 && y == C - 1 && d == K) {
            answer++;
            return;
        }

        for (int next = 0; next < 4; next++) {
            int nx = x + dx[next];
            int ny = y + dy[next];

            if (0 > nx || nx >= R || 0 > ny || ny >= C || board[nx][ny] == 'T' || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, d + 1);
            visited[nx][ny] = false;
        }
    }
}
