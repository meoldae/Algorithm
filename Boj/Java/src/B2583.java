import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2583 {
    static int M, N, K;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int lbY = Integer.parseInt(st.nextToken());
            int lbX = M - Integer.parseInt(st.nextToken());
            int rtY = Integer.parseInt(st.nextToken());
            int rtX = M - Integer.parseInt(st.nextToken());

            for (int x = rtX; x < lbX; x++) {
                for (int y = lbY; y < rtY; y++) {
                    board[x][y] = 1;
                }
            }
        }

        Queue<Integer> pq = new PriorityQueue<>();
        visited = new boolean[M][N];
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited[x][y] && board[x][y] == 0) {
                    visited[x][y] = true;
                    pq.add(getAreaSize(x, y));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.print(sb);
    }

    public static int getAreaSize(int x, int y) {
        int result = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= M || 0 > ny || ny >= N || visited[nx][ny] || board[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                result++;
            }
        }
        return result;
    }
}
