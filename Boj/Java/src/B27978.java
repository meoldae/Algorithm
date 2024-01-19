import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B27978 {
    static int H, W;
    static char[][] board;
    static int[][] visited;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new char[H][W];
        visited = new int[H][W];
        int x = 0;
        int y = 0;

        for (int i = 0; i < H; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 'K') {
                    x = i;
                    y = j;
                }
            }
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        int answer = dijkstra(x, y);
        System.out.print(answer);
    }

    private static int dijkstra(int x, int y) {
        int result = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = 0;
        queue.offer(new int[]{x, y, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[2] > visited[now[0]][now[1]]) continue;
            if (board[now[0]][now[1]] == '*' && visited[now[0]][now[1]] != Integer.MAX_VALUE) {
                result = visited[now[0]][now[1]];
            }

            for (int d = 0; d < 8; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= H || 0 > ny || ny >= W || board[nx][ny] == '#') continue;

                int distance = now[2] + 1;
                if (d >= 5) distance--;

                if (visited[nx][ny] > distance) {
                    visited[nx][ny] = distance;
                    queue.offer(new int[]{nx, ny, distance});
                }
            }
        }
        return result;
    }
}
