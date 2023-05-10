import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17836 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] castle = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] visited = new int[2][N][M];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= M) continue;

                if (now[2] == 0) {
                    if (visited[now[2]][nx][ny] == 0 && castle[nx][ny] != 1) {
                        if (castle[nx][ny] == 2) {
                            visited[1][nx][ny] = visited[0][now[0]][now[1]] + 1;
                            queue.offer(new int[]{nx, ny, 1});
                        }
                        visited[now[2]][nx][ny] = visited[now[2]][now[0]][now[1]] + 1;
                        queue.offer(new int[]{nx, ny, now[2]});
                    }
                } else {
                    if (visited[now[2]][nx][ny] == 0) {
                        visited[now[2]][nx][ny] = visited[now[2]][now[0]][now[1]] + 1;
                        queue.offer(new int[]{nx, ny, now[2]});
                    }
                }
            }
        }
        int answer = Math.min(visited[0][N-1][M-1] - 1, visited[1][N-1][M-1] - 1);
        if (visited[0][N-1][M-1] - 1 == -1 || visited[1][N-1][M-1] - 1 == -1) {
            answer = Math.max(visited[0][N-1][M-1] - 1, visited[1][N-1][M-1] - 1);
        }
        if (answer == -1) {
            System.out.print("Fail");
        }else {
            System.out.print(answer <= T ? answer : "Fail");
        }
    }
}
