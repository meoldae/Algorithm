import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B8972 {
    static char[][] board;
    static int[][] removed;
    static int R, C;
    static int x, y;
    static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        removed = new int[R][C];

        Queue<int[]> robots = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'I') {
                   x = i;
                   y = j;
                   board[i][j] = '.';
                }
                if (board[i][j] == 'R') {
                    robots.offer(new int[]{i, j});
                }
            }
        }

        int answer = 0;
        String command = br.readLine();
        outer:
        for (int i = 0; i < command.length(); i++) {
            int d = Character.getNumericValue(command.charAt(i));

            // 1. 종수의 아두이노를 이동시킨다.
            x += dx[d];
            y += dy[d];
            // 2. 이동한 종수의 아두이노가 미친 아두이노가 있는 칸이라면 게임 종료
            if (board[x][y] == 'R') {
                answer = i + 1;
                break outer;
            }

            // 3. 미친 아두이노가 종수의 아두이노와 가까워지는 방향으로 이동
            int l = robots.size();
            for (int r = 0; r < l; r++) {
                int[] robot = robots.poll();
                board[robot[0]][robot[1]] = '.';
                int rd = getDirection(robot);
                int rx = robot[0] + dx[rd];
                int ry = robot[1] + dy[rd];

                // 4. 이동한 미친 아두이노가 종수의 아두이노가 있는 칸이라면 게임 종료
                if (rx == x && ry == y) {
                    answer = i + 1;
                    break outer;
                }

                // 5. 2개 이상의 미친 아두이노가 있다면 모두 파괴한다.
                if (++removed[rx][ry] < 2) {
                    robots.offer(new int[]{rx, ry});
                }
            }

            l = robots.size();
            for (int r = 0; r < l; r++) {
                int[] robot = robots.poll();
                // 5. 2개 미만의 미친 아두이노가 있는 칸만 배치
                if (removed[robot[0]][robot[1]] < 2) {
                    board[robot[0]][robot[1]] = 'R';
                    robots.offer(robot);
                }
                removed[robot[0]][robot[1]] = 0;
            }
        }

        if (answer != 0) {
            System.out.print("kraj " + answer);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (i == x && j == y) sb.append('I');
                    else sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    public static int getDirection(int[] robot) {
        int rx = robot[0];
        int ry = robot[1];

        if (x > rx){
            if (y < ry) return 1;
            else if (y == ry) return 2;
            else return 3;
        } else if (x == rx) {
            if (y < ry) return 4;
            else if (y > ry) return 6;
        } else {
            if (y < ry) return 7;
            else if (y == ry) return 8;
            else return 9;
        }
        return -1;
    }
}
