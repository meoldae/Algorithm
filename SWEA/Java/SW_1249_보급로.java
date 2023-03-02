import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SW_1249_보급로 {
    static int N;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }
            sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs() {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[]{0, 0, 0});

        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == N - 1 && now[1] == N - 1) return now[2];

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        pq.offer(new int[]{nx, ny, now[2] + board[nx][ny]-'0'});
                    }
                }
            }
        }
        return 0;
    }
}
