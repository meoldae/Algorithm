import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13460 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int[] blue = {};
        int[] red = {};

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'R') {
                    red = new int[]{i, j};
                    board[i][j] = '.';
                }
                if (board[i][j] == 'B') {
                    blue = new int[]{i, j};
                    board[i][j] = '.';
                }
            }
        }
        int answer = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{blue[0], blue[1], red[0], red[1], 0});
        outer:
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[4] >= 10) break;

            boolean isMoved = false;
            for (int d = 0; d < 4; d++) {
                int[] next = moveBall(now, d);
                if (next[4] == -1) continue;
                else if (next[4] == 1) {
                    answer = now[4] + 1;
                    break outer;
                } else if (next[4] == 2) queue.offer(new int[]{next[0], next[1], next[2], next[3], now[4] + 1});
                isMoved = true;
            }
            if (!isMoved) break;
        }
        System.out.print(answer);
    }

    public static int[] moveBall(int[] prev, int d) {
        int bx = prev[0];
        int by = prev[1];
        int rx = prev[2];
        int ry = prev[3];
        int result = 2;

        int nrx = -1;
        int nry = -1;
        while (true) {
            int nbx = bx + dx[d];
            int nby = by + dy[d];

            if (rx != 0 && ry != 0){
                nrx = rx + dx[d];
                nry = ry + dy[d];
            }

            if (board[nbx][nby] == '#') {
                nbx -= dx[d];
                nby -= dy[d];
            }

            if (rx != 0 && ry != 0) {
                if (board[nrx][nry] == '#') {
                    nrx -= dx[d];
                    nry -= dy[d];
                }
            }

            if (board[nrx][nry] == 'O') {
                nrx = 0;
                nry = 0;
                result = 1;
            }

            // 둘 다 빠졌을 때
            if (board[nbx][nby] == 'O') return new int[]{nbx, nby, nrx, nry, -1};

            if (nrx == nbx && nry == nby) { // 공이 겹쳤을 때
                if (d == 0) { // 상
                    if (rx < bx) nbx -= dx[d];
                    else nrx -= dx[d];
                } else if (d == 1) { // 우
                    if (ry > by) nby -= dy[d];
                    else nry -= dy[d];
                } else if (d == 2) { // 하
                    if (rx > bx) nbx -= dx[d];
                    else nrx -= dx[d];
                } else { // 좌
                    if (ry < by) nby -= dy[d];
                    else nry -= dy[d];
                }
            }
            if (nbx == prev[0] && nby == prev[1] && nrx == prev[2] && nry == prev[3]) result = 3;
            if (bx == nbx && by == nby && ((rx == nrx && ry == nry) || (nrx == 0 && nry == 0))) return new int[]{bx, by, rx, ry, result};

            bx = nbx;
            by = nby;
            rx = nrx;
            ry = nry;
        }
    }
}
