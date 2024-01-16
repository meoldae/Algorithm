import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class B20947 {
    static char[][] city;
    static char[][] bomb;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        city = new char[N][N];
        bomb = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                city[i][j] = input[j];
                bomb[i][j] = input[j];
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (city[r][c] == 'X') {
                    explore(r, c);
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (city[r][c] == 'O') {
                    explore(r, c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (bomb[r][c] == 'B') {
                    city[r][c] = 'B';
                }
                sb.append(city[r][c]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void explore(int r, int c) {
        char value = 'C';
        if (city[r][c] == 'X') value = 'B';

        Queue<int[]> queue = new ArrayDeque<>();
        for (int d = 0; d < 4; d++) queue.offer(new int[]{r, c, d});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0] + dx[now[2]];
            int ny = now[1] + dy[now[2]];

            if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;
            if (city[nx][ny] == '.') {
                bomb[nx][ny] = value;
                queue.offer(new int[]{nx, ny, now[2]});
            }
        }

    }
}
