import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B24513 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] village = new int[N][M];
        Queue<int[]> viruses = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                village[i][j] = Integer.parseInt(st.nextToken());
                if (village[i][j] == 1 || village[i][j] == 2) {
                    viruses.offer(new int[]{i, j, village[i][j]});
                }
            }
        }

        int[][] visited = new int[N][M];

        while (!viruses.isEmpty()) {
            int[] virus = viruses.poll();

            int x = virus[0];
            int y = virus[1];
            int type = virus[2];

            if (village[x][y] == 3) continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= M) continue;
                if (village[nx][ny] == -1) continue;

                if (village[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    village[nx][ny] = type;
                    viruses.offer(new int[]{nx, ny, type});
                } else if (village[nx][ny] + type == 3) {
                    if (visited[nx][ny] == visited[x][y] + 1) {
                        village[nx][ny] = 3;
                    }
                }
            }
        }

        int[] count = new int[4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (village[i][j] != -1) count[village[i][j]]++;
            }
        }
        System.out.print(count[1] + " " + count[2] + " " + count[3]);
    }
}
