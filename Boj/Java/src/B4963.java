import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4963 {
    static int[][] board, visited;
    static int W, H;
    static int[] dx = new int[]{0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = new int[]{1, -1, 0, 0, -1, 1, -1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) break;
            board = new int[H][W];
            for (int i = 0; i < H; i++)
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            isIsland();
        }
        System.out.println(sb);
    }

    static void isIsland() {
        visited = new int[H][W];
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 1 && visited[i][j] == 0) bfs(++count, i, j);
            }
        }
        sb.append(count).append("\n");
    }

    static void bfs(int count, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = count;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 8; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && nx < H && 0 <= ny && ny < W) {
                    if (board[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = count;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
