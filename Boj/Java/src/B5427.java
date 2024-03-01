import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427 {
    static char[][] building;
    static int w, h;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            building = new char[h][w];


            Queue<int[]> fires = new ArrayDeque<>();
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                building[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (building[i][j] == '@') {
                        queue.offer(new int[]{i, j, 0});
                        building[i][j] = '.';
                        visited[i][j] = true;
                    }
                    if (building[i][j] == '*') {
                        fires.offer(new int[]{i, j});
                    }
                }
            }

            int time = 0;

            outer:
            while (!queue.isEmpty()) {

                spreadFire(fires);

                int queueSize = queue.size();
                for (int i = 0; i < queueSize; i++) {
                    int[] now = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = now[0] + dx[d];
                        int ny = now[1] + dy[d];

                        if (0 > nx || nx >= h || 0 > ny || ny >= w) {
                            time = now[2] + 1;
                            break outer;
                        }
                        if (visited[nx][ny] || building[nx][ny] == '#' || building[nx][ny] == '*') continue;
                        queue.offer(new int[]{nx, ny, now[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
            sb.append(time == 0 ? "IMPOSSIBLE" : time).append("\n");
        }
        System.out.print(sb);
    }

    static void spreadFire(Queue<int[]> fires) {
        int fireSize = fires.size();
        for (int i = 0; i < fireSize; i++) {
            int[] fire = fires.poll();

            for (int d = 0; d < 4; d++) {
                int nx = fire[0] + dx[d];
                int ny = fire[1] + dy[d];

                if (0 > nx || nx >= h || 0 > ny || ny >= w) continue;
                if (building[nx][ny] == '.') {
                    building[nx][ny] = '*';
                    fires.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
