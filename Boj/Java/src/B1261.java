import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1261 {
    static int N, M;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
        System.out.print(dijkstra());
    }

    public static int dijkstra() {
        int[][] distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[2] > distance[now[0]][now[1]]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= M) continue;
                if (board[nx][ny] == 1) {
                    if (distance[nx][ny] > now[2] + 1) {
                        distance[nx][ny] = now[2] + 1;
                        pq.offer(new int[]{nx, ny, now[2] + 1});
                    }
                } else {
                    if (distance[nx][ny] > now[2]) {
                        distance[nx][ny] = now[2];
                        pq.offer(new int[]{nx, ny, now[2]});
                    }
                }
            }
        }
        return distance[N - 1][M - 1];
    }
}
