import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] visited = new int[K + 1][H][W];
        int[][] board = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0, 0, 1, -1, -1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});

        int answer = Integer.MAX_VALUE;
        outer:
        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == H - 1 && now[1] == W - 1) {
                answer = visited[now[2]][now[0]][now[1]];
                break;
            }

            for (int d = 0; d < 12; d++) {
                int count = now[2];
                if (d >= 4) count++;
                if (count > K) continue outer;

                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= H || 0 > ny || ny >= W) continue;
                if (board[nx][ny] == 1) continue;
                if (visited[count][nx][ny] != 0 && visited[count][nx][ny] <= visited[now[2]][now[0]][now[1]] + 1) continue;
                visited[count][nx][ny] = visited[now[2]][now[0]][now[1]] + 1;
                queue.offer(new int[]{nx, ny, count});
            }
        }
        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
