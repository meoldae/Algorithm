import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1926 {
    static int[][] paint;
    static boolean[][] visited;
    static int maxArea, count, n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paint = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && paint[i][j] == 1){
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }
        System.out.print(count + "\n" + maxArea);
    }

    public static void bfs(int x, int y) {
        count++;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{x, y});
        int tempArea = 0;
        while(!queue.isEmpty()) {
            tempArea++;
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= n || 0 > ny || ny >= m || visited[nx][ny]) continue;
                if (paint[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        maxArea = Math.max(maxArea, tempArea);
    }
}
