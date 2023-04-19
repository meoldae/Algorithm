import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1726 {
    static int M, N;
    static int[][] board;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] src = new int[3];
        int[] dst = new int[3];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            src[i] = Integer.parseInt(st.nextToken());
            dst[i] = Integer.parseInt(st1.nextToken());
        }
        System.out.print(bfs(src, dst));

    }

    static int bfs(int[] src, int[] dst) {
        boolean[][][] visited = new boolean[5][M][N];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src[0] - 1, src[1] - 1, src[2], 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == dst[0] -1 && now[1] == dst[1] -1 && now[2] == dst[2]){
                return now[3];
            }

            for (int i = 1; i <= 3; i++) {
                int nx = now[0] + (dx[now[2]] * i);
                int ny = now[1] + (dy[now[2]] * i);

                if (0 > nx || nx >= M || 0 > ny || ny >= N) continue;

                if (board[nx][ny] == 1) break;

                if (!visited[now[2]][nx][ny]) {
                    visited[now[2]][nx][ny] = true;
                    queue.offer(new int[]{nx, ny, now[2], now[3] + 1});
                }
            }

            for (int d = 1; d <= 4; d++) {
                int turnCount = getTurnCount(now[2], d);
                if (!visited[d][now[0]][now[1]]) {
                    visited[d][now[0]][now[1]] = true;
                    queue.offer(new int[]{now[0], now[1], d, now[3] + turnCount});
                }
            }
        }
        return 0;
    }

    static int getTurnCount(int prev, int next){
        int result;

        if (prev == next) result = 0;
        else if ((prev == 1 || prev == 2) && (next == 3 || next == 4)) result = 1;
        else if ((prev == 3 || prev == 4) && (next == 1 || next == 2)) result = 1;
        else result = 2;

        return result;
    }
}