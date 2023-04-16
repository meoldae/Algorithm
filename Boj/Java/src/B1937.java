import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1937 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] board;
    static int[][] visited;
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) answer = Math.max(answer, dfs(i, j));
        }
        System.out.print(answer);
    }

    static int dfs(int x, int y) {
        if (visited[x][y] != 0) return visited[x][y];
        visited[x][y] = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;

            if (board[nx][ny] > board[x][y]) {
                visited[x][y] = Math.max(visited[x][y], dfs(nx, ny) + 1);
            }
        }
        return visited[x][y];
    }
}
