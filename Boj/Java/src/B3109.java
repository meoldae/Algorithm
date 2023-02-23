import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3109 {
    static char[][] board;
    static int R, C;
    static int[] dx = {-1, 0, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < R; i++) {
            pipeLine(i, 0);
        }
        System.out.println(count);
    }

    static boolean pipeLine(int x, int y) {
        if (y == C - 1) {
            count++;
            return true;
        }
        for (int d = 0; d < 3; d++) {
            int nx = x + dx[d];
            int ny = y + 1;
            if (0 <= nx && nx < R && board[nx][ny] != (char) 1 && board[nx][ny] != 'x') {
                board[nx][ny] = (char) 1;
                if (pipeLine(nx, ny)) return true;
            }
        }
        return false;
    }
}
