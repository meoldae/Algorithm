import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14923 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken()) - 1;
        int Hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken()) - 1;
        int Ey = Integer.parseInt(st.nextToken()) - 1;

        int[][] maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{Hx, Hy, 0});

        int[][][] visited = new int[2][N][M];

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == Ex && now[1] == Ey) {
                answer = Math.min(answer, visited[now[2]][now[0]][now[1]]);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= M) continue;
                if (maze[nx][ny] == 0 && visited[now[2]][nx][ny] == 0) {
                    visited[now[2]][nx][ny] = visited[now[2]][now[0]][now[1]] + 1;
                    queue.offer(new int[]{nx, ny, now[2]});
                } else if (maze[nx][ny] == 1 && now[2] == 0) {
                    visited[1][nx][ny] = visited[now[2]][now[0]][now[1]] + 1;
                    queue.offer(new int[]{nx, ny, 1});
                }
            }
        }
        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
