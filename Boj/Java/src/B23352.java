import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B23352 {
    static int N, M, count;
    static int[][] board;
    static int answer;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.print(answer == 0 ? -1 : answer);
    }

    static void bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (count < now[2]) {
                count = now[2];
                answer = board[now[0]][now[1]];
            } else if (count == now[2]) {
                answer = Math.max(answer, board[x][y] + board[now[0]][now[1]]);
            }

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= M || visited[nx][ny] || board[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, now[2] + 1});
            }
        }
    }
}
