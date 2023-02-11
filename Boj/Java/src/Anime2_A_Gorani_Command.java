import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Anime2_A_Gorani_Command {
    static int n, m;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n - 1; i++) {
            int distance = Integer.parseInt(br.readLine());
            bfs(i, 0, distance);
        }
        String[] col = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            bfs(n-1, i, Integer.parseInt(col[i]));
        }
    }

    static void bfs(int x, int y, int distance){
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, distance});
        visited[x][y] = true;
        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (now[2] == 0) {
                board[now[0]][now[1]]++;
                if (board[now[0]][now[1]] == n+m-1){
                    System.out.println((now[0]+1) + " " + (now[1]+1));
                    return;
                }
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (visited[nx][ny]) continue;
                    if (now[2] > 0) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, now[2] - 1});
                    }
                }
            }
        }
    }
}
