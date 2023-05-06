import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179 {
    public static void main(String[] args) throws IOException {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];
        Queue<int[]> J = new ArrayDeque<>();
        Queue<int[]> fire = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++){
                if (board[i][j] == 'J') {
                    J.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
                else if (board[i][j] == 'F') fire.offer(new int[]{i, j});
            }
        }

        int count = 0;
        while(!J.isEmpty()) {
            int fireSize = fire.size();
            for (int s = 0; s < fireSize; s++) {
                int[] nextFire = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nxFire = nextFire[0] + dx[d];
                    int nyFire = nextFire[1] + dy[d];

                    if (0 > nxFire || nxFire >= R || 0 > nyFire || nyFire >= C) continue;
                    if (board[nxFire][nyFire] != '#' && board[nxFire][nyFire] != 'F') {
                        board[nxFire][nyFire] = 'F';
                        fire.offer(new int[]{nxFire, nyFire});
                    }
                }
            }

            int jSize = J.size();
            for (int s = 0; s < jSize; s++) {
                int[] nextJ = J.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = nextJ[0] + dx[d];
                    int ny = nextJ[1] + dy[d];

                    if (0 > nx || nx >= R || 0 > ny || ny >= C) {
                        System.out.print(count + 1);
                        return;
                    }
                    if (board[nx][ny] != '#' && board[nx][ny] != 'F' && !visited[nx][ny]) {
                        J.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }
        System.out.print("IMPOSSIBLE");
    }
}
