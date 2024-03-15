import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14442 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N;  i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j] - '0';
            }
        }

        boolean[][][] visited = new boolean[K + 1][N][M];
        visited[0][0][0] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0, 1}); // x, y, 벽 파괴 횟수, 걸린 시간(시작하는 곳도 센다.)

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                System.out.print(now[3]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= M) continue;
                if (map[nx][ny] == 0) {
                    if (visited[now[2]][nx][ny]) continue;
                    visited[now[2]][nx][ny] = true;
                    queue.offer(new int[]{nx, ny, now[2], now[3] + 1});
                } else {
                    if (now[2] == K || visited[now[2] + 1][nx][ny]) continue;
                    visited[now[2] + 1][nx][ny] = true;
                    queue.offer(new int[]{nx, ny, now[2] + 1, now[3] + 1});
                }
            }
        }
        System.out.print(-1);  // 탈출 불가한 경우
    }
}