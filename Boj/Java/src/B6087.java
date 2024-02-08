import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B6087 {
    static int H, W;
    static int answer = Integer.MAX_VALUE;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new char[H][W];

        int x = 0;
        int y = 0;
        for (int i = 0; i < H; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 'C') {
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x, y);
        System.out.print(answer);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);

        int[][][] visited = new int[4][H][W];
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < H; i++) {
                Arrays.fill(visited[d][i], Integer.MAX_VALUE);
            }
        }

        for (int d = 0; d < 4; d++) {
            queue.offer(new int[]{x, y, d, 0});
            visited[d][x][y] = 0;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (board[now[0]][now[1]] == 'C' && (now[0] != x || now[1] != y)) { // C 이지만 시작점이 아니라면 도착
                answer = Math.min(answer, now[3]);
                continue;
            }

            if (now[3] > visited[now[2]][now[0]][now[1]]) continue;

            for (int d = 0; d < 4; d++) {
                if ((now[2] + 2) % 4 == d) continue; // 역방향은 제외
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                int count = (d == now[2]) ? now[3] : now[3] + 1;

                if (0 > nx || nx >= H || 0 > ny || ny >= W) continue;
                if (visited[d][nx][ny] <= count || board[nx][ny] == '*') continue;

                queue.offer(new int[]{nx, ny, d, count});
                visited[d][nx][ny] = count;

            }
        }
    }
}
