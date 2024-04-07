import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18430 {
    static int[][] dx = {{0, 1}, {-1, 0}, {-1, 0}, {0, 1}};
    static int[][] dy = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    static boolean[][] visited;
    static int[][] board;
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (N < 2 || M < 2) {
            System.out.print(0);
            return;
        }

        dfs(0, 0, 0);
        System.out.print(answer);
    }

    public static void dfs(int x, int y, int sum) {
        if (x == N) {
            answer = Math.max(answer, sum);
            return;
        }

        int ny = (y + 1) % M;
        int nx = ny == 0 ? x + 1 : x;

        for (int d = 0; d < 4; d++) {
            int nx1 = x + dx[d][0];
            int nx2 = x + dx[d][1];
            int ny1 = y + dy[d][0];
            int ny2 = y + dy[d][1];

            if (nx1 < 0 || nx2 < 0 || ny1 < 0 || ny2 < 0 || nx1 >= N || nx2 >= N || ny1 >= M || ny2 >= M) continue;
            if (visited[nx1][ny1] || visited[nx2][ny2] || visited[x][y]) continue;

            visited[nx1][ny1] = visited[nx2][ny2] = visited[x][y] = true;

            dfs(nx, ny, sum + getIntensity(nx1, nx2, ny1, ny2, x, y));

            visited[nx1][ny1] = visited[nx2][ny2] = visited[x][y] = false;
        }
        dfs(nx, ny, sum);
    }

    public static int getIntensity(int nx1, int nx2, int ny1, int ny2, int x, int y) {
        return board[nx1][ny1] + board[nx2][ny2] + (board[x][y] * 2);
    }
}
