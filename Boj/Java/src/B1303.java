import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1303 {
    static char[][] board;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) board[i] = br.readLine().toCharArray();

        int blue = 0;
        int white = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                if (board[i][j] == 'B') blue += getPower(i, j);
                else white += getPower(i, j);
            }
        }
        System.out.print(white + " " + blue);
    }

    public static int getPower(int x, int y) {
        int sum = 1;
        char team = board[x][y];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= m || 0 > ny || ny >= n || board[nx][ny] != team || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                sum++;
            }
        }
        return (int) Math.pow(sum, 2);
    }
}
