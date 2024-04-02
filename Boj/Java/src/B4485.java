import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int N;
        int count = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] cave = new int[N][N];
            int[][] visited = new int[N][N];
            for (int i = 0; i < N; i++) {

                Arrays.fill(visited[i], Integer.MAX_VALUE);

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0, 0});
            visited[0][0] = cave[0][0];

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;
                    if (visited[nx][ny] <= visited[now[0]][now[1]] + cave[nx][ny]) continue;
                    visited[nx][ny] = visited[now[0]][now[1]] + cave[nx][ny];
                    queue.offer(new int[]{nx, ny});
                }
            }
            sb.append("Problem ").append(count++).append(": ").append(visited[N - 1][N - 1]).append("\n");
        }
        System.out.print(sb);
    }
}