import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2146 {
    static int[][] board;
    static int N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int order = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) union(i, j, order++);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) bfs(i, j, board[i][j]);
            }
        }
        System.out.print(answer);
    }

    static void union(int x, int y, int order) {
        boolean[][] island = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        island[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            board[now[0]][now[1]] = order;

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= N || board[nx][ny] == 0 || island[nx][ny]) continue;
                island[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    static void bfs(int x, int y, int start) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.offer(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= N || board[nx][ny] == start || visited[nx][ny]) continue;
                if(board[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny, now[2] + 1});
                } else {
                    answer = Math.min(answer, now[2]);
                }
                visited[nx][ny] = true;
            }
        }
    }
}
