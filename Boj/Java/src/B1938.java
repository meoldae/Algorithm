import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class B1938 {
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int N;
    static char[][] board;
    static int[][] pillar;
    static int[][] dst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        pillar = new int[3][2];
        dst = new int[3][2];
        int pCount = 0, dCount = 0;
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'B') {
                    pillar[pCount][0] = i;
                    pillar[pCount++][1] = j;
                }
                if (board[i][j] == 'E') {
                    dst[dCount][0] = i;
                    dst[dCount++][1] = j;
                }
            }
        }
        bfs();
    }

    static void bfs() {
        int[][][] visited = new int[2][N][N];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        int status = 0;
        if (pillar[0][0] == pillar[1][0]) status = 0;
        else status = 1;

        Queue<int[]> queue = new ArrayDeque<>();
        visited[status][pillar[1][0]][pillar[1][1]] = 0;
        queue.offer(new int[]{pillar[1][0], pillar[1][1], status});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            if (isDst(now)) {
                System.out.print(visited[now[2]][now[0]][now[1]]);
                return;
            }

            for (int d = 0; d < 5; d++) {
                if (d < 4) {
                    if (isMove(d, now)) {
                        int nx = now[0] + dx[d];
                        int ny = now[1] + dy[d];
                        if (visited[now[2]][nx][ny] > visited[now[2]][now[0]][now[1]] + 1) {
                            visited[now[2]][nx][ny] = visited[now[2]][now[0]][now[1]] + 1;
                            queue.offer(new int[] {nx, ny, now[2]});
                        }
                    }
                }else {
                    if (isTurn(now)) {
                        int nextStatus = (now[2] + 1) % 2;
                        if (visited[nextStatus][now[0]][now[1]] > visited[now[2]][now[0]][now[1]] + 1) {
                            visited[nextStatus][now[0]][now[1]] = visited[now[2]][now[0]][now[1]] + 1;
                            queue.offer(new int[] {now[0], now[1], nextStatus});
                        }
                    }
                }
            }
        }
        System.out.print(0);
    }

    static boolean isTurn(int[] now) {
        for (int d = 0; d < 8; d++) {
            int nx = now[0] + dx[d];
            int ny = now[1] + dy[d];

            if (0 > nx || nx >= N || 0 > ny || ny >= N || board[nx][ny] == '1') {
                return false;
            }
        }
        return true;
    }

    static boolean isMove(int d, int[] now) {
        if (now[2] == 0) {
            if (d == 0) {
                if (now[0] == 0) {
                    return false;
                }
                for (int i = now[1] - 1; i < now[1] + 2; i++) {
                    if (board[now[0] - 1][i] == '1') {
                        return false;
                    }
                }
            }else if (d == 1) {
                if (now[1] + 2 >= N || board[now[0]][now[1] + 2] == '1') {
                    return false;
                }

            }else if (d == 2) {
                if (now[0] >= N - 1) {
                    return false;
                }
                for (int i = now[1] - 1; i < now[1] + 2; i++) {
                    if (board[now[0] + 1][i] == '1') {
                        return false;
                    }
                }
            }else {
                if (now[1] - 2 < 0 || board[now[0]][now[1] - 2] == '1') {
                    return false;
                }
            }
        }else {
            if (d == 0) {
                if (now[0] - 2 < 0 || board[now[0] - 2][now[1]] == '1') {
                    return false;
                }
            }else if (d == 1) {
                if (now[1] >= N - 1) {
                    return false;
                }
                for (int i = now[0] - 1; i < now[0] + 2; i++) {
                    if (board[i][now[1] + 1] == '1') {
                        return false;
                    }
                }
            }else if (d == 2) {
                if (now[0] + 2 >= N || board[now[0] + 2][now[1]] == '1') {
                    return false;
                }
            }else {
                if (now[1] <= 0) return false;
                for (int i = now[0] - 1; i < now[0] + 2; i++) {
                    if (board[i][now[1] - 1] == '1') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean isDst(int[] now) {
        if (now[2] == 0) {
            for (int i = now[1] - 1; i < now[1] + 2; i++) {
                if (board[now[0]][i] != 'E') return false;
            }
        }else {
            for (int i = now[0] - 1; i < now[0] + 2; i++) {
                if (board[i][now[1]] != 'E') return false;
            }
        }
        return true;
    }
}
