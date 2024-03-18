import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13565 {
    static int M, N;
    static char[][] fabric;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        fabric = new char[M][N];
        for (int i = 0; i < M; i++) {
            fabric[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            if (bfs(i)) {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
    }

    public static boolean bfs(int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, y});

        boolean[][] visited = new boolean[M][N];
        visited[0][y] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx == M - 1) return true;

                if (0 > nx || 0 > ny || ny >= N || visited[nx][ny] || fabric[nx][ny] == '1') continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});

            }
        }
        return false;
    }
}
