import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {
    static int R, C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] forest;
    static Queue<int[]> flood;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] S = new int[2];
        forest = new char[R][C];
        flood = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            forest[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (forest[i][j] == 'S') S = new int[]{i, j};
                if (forest[i][j] == '*') flood.offer(new int[]{i, j});
            }
        }
        int answer = bfs(S);
        System.out.print(answer != 0 ? answer : "KAKTUS");
    }

    static int bfs(int[] S) {
        int[][] visited = new int[R][C];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{S[0], S[1]});
        visited[S[0]][S[1]] = 1;

        while(!queue.isEmpty()) {
            int N = queue.size();
            for (int i = 0; i < N; i++) {
                int[] now = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if (0 > nx || nx >= R || 0 > ny || ny >= C) continue;
                    if (visited[nx][ny] != 0) continue;
                    if (forest[nx][ny] == 'D') return visited[now[0]][now[1]];
                    if (forest[nx][ny] == '.' && isMovable(nx, ny)) {
                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            flooding();
        }
        return 0;
    }

    static boolean isMovable(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 > nx || nx >= R || 0 > ny || ny >= C) continue;
            if (forest[nx][ny] == '*') return false;
        }
        return true;
    }

    static void flooding(){
        int N = flood.size();
        for (int i = 0; i < N; i++) {
            int[] now = flood.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= R || 0 > ny || ny >= C) continue;
                if (forest[now[0]][now[1]] == '*' && (forest[nx][ny] == '.' || forest[nx][ny] == 'S')) {
                    flood.offer(new int[]{nx, ny});
                    forest[nx][ny] = '*';
                }
            }
        }
    }
}
