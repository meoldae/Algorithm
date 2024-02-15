import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2344 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] box;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[N + 2][M + 2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> laser = new ArrayDeque<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0, 2, 1});

        for (int i = 1; i < (N + 1) * 2 + (M + 1) * 2; i++) {
            int[] now = queue.poll();

            int nx = now[0] + dx[now[2]];
            int ny = now[1] + dy[now[2]];

            int d = (now[2] + 3) % 4;
            if (0 > nx || nx >= N + 2 || 0 > ny || ny >= M + 2) {
                nx = now[0] + dx[d];
                ny = now[1] + dy[d];
                queue.offer(new int[]{nx, ny, d, now[3]});
            } else {
                box[now[0]][now[1]] = now[3];
                laser.offer(new int[]{now[0], now[1], d});
                queue.offer(new int[]{nx, ny, now[2], now[3] + 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!laser.isEmpty()) {
            sb.append(straight(laser.poll())).append(" ");
        }

        System.out.print(sb);

    }
    public static int straight(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            int nx = now[0] + dx[now[2]];
            int ny = now[1] + dy[now[2]];

            if (nx == 0 || nx == N + 1 || ny == 0 || ny == M + 1) {
                return box[nx][ny];
            }
            int d = now[2];
            if (box[nx][ny] == 1) d ^= 1;
            queue.offer(new int[]{nx, ny, d});
        }

        return -1;
    }
}