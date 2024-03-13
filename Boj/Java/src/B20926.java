import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B20926 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] dungeon = new char[H][W];

        int x = 0;
        int y = 0;
        for (int i = 0; i < H; i++) {
            dungeon[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (dungeon[i][j] == 'T') {
                    x = i;
                    y = j;
                    dungeon[i][j] = '0';
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int[][][] visited = new int[4][H][W];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < H; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int d = 0; d < 4; d++) {
            queue.offer(new int[]{x, y, 0, d});
            visited[d][x][y] = 0;
        }


        while (!queue.isEmpty()) {
            int[] terra = queue.poll();

            if (terra[2] >= answer) continue;

            int nx = terra[0] + dx[terra[3]];
            int ny = terra[1] + dy[terra[3]];

            if (0 > nx || nx >= H || 0 > ny || ny >= W) continue;

            if (dungeon[nx][ny] == 'E') {
                answer = Math.min(answer, terra[2] + 1);
            } else if (dungeon[nx][ny] == 'H') {
                continue;
            } else if (dungeon[nx][ny] == 'R') {
                int d = (terra[3] + 1) % 4;
                if (visited[d][terra[0]][terra[1]] > terra[2]) {
                    visited[d][terra[0]][terra[1]] = terra[2];
                    queue.offer(new int[]{terra[0], terra[1], terra[2], d});
                }
                d = (terra[3] + 3) % 4;
                if (visited[d][terra[0]][terra[1]] > terra[2]) {
                    visited[d][terra[0]][terra[1]] = terra[2];
                    queue.offer(new int[]{terra[0], terra[1], terra[2], d});
                }
            } else {
                int time = dungeon[nx][ny] - '0';
                if (visited[terra[3]][nx][ny] > terra[2] + time) {
                    visited[terra[3]][nx][ny] = terra[2] + time;
                    queue.offer(new int[]{nx, ny, terra[2] + time, terra[3]});
                }
            }
        }
        System.out.print(answer != Integer.MAX_VALUE ? answer - 1 : -1);
    }
}