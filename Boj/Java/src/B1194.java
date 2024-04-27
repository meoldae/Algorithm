import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] maze = new char[N][M];
        boolean[][][] visited = new boolean[64][N][M];
        Now start = null;
        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == '0') {
                    start = new Now(i, j, 0, 0);
                    visited[0][i][j] = true;
                    maze[i][j] = '.';
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Now> queue = new ArrayDeque<>();
        queue.offer(start);
        int answer = -1;

        while (!queue.isEmpty()) {
            Now now = queue.poll();

            if (maze[now.x][now.y] == '1') {
                answer = now.count;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (0 > nx || nx >= N || 0 > ny || ny >= M || maze[nx][ny] == '#' || visited[now.keys][nx][ny]) continue;


                if (maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f') {
                    int nextKeys = now.keys | (1 << (maze[nx][ny] - 'a'));
                    visited[nextKeys][nx][ny] = true;
                    queue.offer(new Now(nx, ny, now.count + 1, nextKeys));
                }

                else if (maze[nx][ny] >= 'A' && maze[nx][ny] <= 'F') {
                    if ((now.keys & (1 << maze[nx][ny] - 'A')) != 0) {
                        visited[now.keys][nx][ny] = true;
                        queue.offer(new Now(nx, ny, now.count + 1, now.keys));
                    }
                }

                else {
                    visited[now.keys][nx][ny] = true;
                    queue.offer(new Now(nx, ny, now.count + 1, now.keys));
                }
            }
        }
        System.out.print(answer);
    }

    static class Now {
        int x;
        int y;
        int count;
        int keys;

        Now(int x, int y, int count, int key) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.keys = key;
        }
    }
}
