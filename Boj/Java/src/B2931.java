import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2931 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        for (int i = 0; i < R; i++) board[i] = br.readLine().toCharArray();

        int x = 0;
        int y = 0;
        outer:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // M, Z과 인접한 파이프가 유실되었을 경우가 있으므로 임의의 파이프 한 곳에서 시작한다.
                if (board[i][j] != '.' && board[i][j] != 'M' && board[i][j] != 'Z') {
                    x = i;
                    y = j;
                    break outer;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int d = 0; d < 4; d++) {
            if (d == 0 && (board[x][y] == 45 || board[x][y] == 49 || board[x][y] == 52)) continue;
            else if (d == 1 && (board[x][y] == 124 || board[x][y] == 51 || board[x][y] == 52)) continue;
            else if (d == 2 && (board[x][y] == 45 || board[x][y] == 50 || board[x][y] == 51)) continue;
            else if (d == 3 && (board[x][y] == 124 || board[x][y] == 49 || board[x][y] == 50)) continue;
            queue.offer(new int[]{x, y, d});
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            int nx = now[0] + dx[now[2]];
            int ny = now[1] + dy[now[2]];

            if (0 > nx || nx >= R || 0 > ny || ny >= C) continue;
            // 크로아티아, 러시아에 도달한 경우 탐색 중지
            if (board[nx][ny] == 'M' || board[nx][ny] == 'Z') continue;

            if (board[nx][ny] == '.') {
                System.out.print((nx + 1) + " " + (ny + 1) + " " + (char) getOriginBlock(nx, ny, board));
                break;
            }
            else queue.offer(new int[]{nx, ny, nextD(now[2], board[nx][ny])});
        }
    }

    // 가스의 흐름은 단 하나. 판별할 필요가 없다..?
    static boolean canMove(int d, int next) {
        if (d == 0 && (next == 43 || next == 49 || next == 52 || next == 124)) return true;
        else if (d == 1 && (next == 43 || next == 45 || next == 51 || next == 52)) return true;
        else if (d == 2 && (next == 43 || next == 50 || next == 51 || next == 124)) return true;
        else if (d == 3 && (next == 43 || next == 45 || next == 49 || next == 50)) return true;
        return false;
    }
    static int getOriginBlock(int x, int y, char[][] board) {
        boolean[] canMove = new boolean[4];
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[nx].length || board[nx][ny] == '.') continue;
//            if (board[nx][ny] == 'M' || board[nx][ny] == 'Z' || canMove(d, board[nx][ny])) canMove[d] = true;
            if (canMove(d, board[nx][ny])) canMove[d] = true;
        }
        if (canMove[0] && canMove[1] && canMove[2] && canMove[3]) return 43;
        else if (canMove[0] && canMove[2]) return 124;
        else if (canMove[1] && canMove[3]) return 45;
        else if (canMove[1] && canMove[2]) return 49;
        else if (canMove[1] && canMove[0]) return 50;
        else if (canMove[3] && canMove[0]) return 51;
        else if (canMove[3] && canMove[2]) return 52;
        else return 0;
    }

    static int nextD(int d, int next) {
        if (d == 0) {
            if (next == 124 || next == 43) return 0;
            else if (next == 49) return 1;
            else if (next == 52) return 3;
        } else if (d == 1) {
            if (next == 45 || next == 43) return 1;
            else if (next == 51) return 0;
            else if (next == 52) return 2;
        } else if (d == 2) {
            if (next == 124 || next == 43) return 2;
            else if (next == 50) return 1;
            else if (next == 51) return 3;
        } else if (d == 3) {
            if (next == 45 || next == 43) return 3;
            else if (next == 49) return 2;
            else if (next == 51) return 3;
        }
        return 4;
    }
}